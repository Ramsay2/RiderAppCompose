package com.apnamart.apnarider.core_app_framework.storage.cache

import kotlin.math.roundToInt

/**
 * A general purpose size limited cache that evicts items using an LRU algorithm. By default every
 * item is assumed to have a size of one. Subclasses can override [.getSize]} to
 * change the size on a per item basis.
 *
 * @param <KEY> The type of the keys.
 * @param <VALUE> The type of the values.
</VALUE></KEY> */
open class LruCache<KEY, VALUE>
/**
 * Constructor for LruCache.
 *
 * @param initialMaxSize The maximum size of the cache, the units must match the units used in [             ][.getSize].
 */
(private val initialMaxSize: Long) {
    private val cache = LinkedHashMap<KEY, VALUE>(100, 0.75f, true)
    /**
     * Returns the current maximum size of the cache in bytes.
     */
    @get:Synchronized
    var maxSize: Long = 0
        private set
    /**
     * Returns the sum of the sizes of all items in the cache.
     */
    @get:Synchronized
    var currentSize: Long = 0
        private set

    /**
     * Returns the number of entries stored in cache.
     */
    protected val count: Int
        @Synchronized get() = cache.size

    init {
        this.maxSize = initialMaxSize
    }

    /**
     * Sets a size multiplier that will be applied to the size provided in the constructor to put the
     * new size of the cache. If the new size is less than the current size, entries will be evicted
     * until the current size is less than or equal to the new size.
     *
     * @param multiplier The multiplier to apply.
     */
    @Synchronized
    fun setSizeMultiplier(multiplier: Float) {
        if (multiplier < 0) {
            throw IllegalArgumentException("Multiplier must be >= 0")
        }
        maxSize = (initialMaxSize * multiplier).roundToInt().toLong()
        evict()
    }

    /**
     * Returns the size of a given item, defaulting to one. The units must match those used in the
     * size passed in to the constructor. Subclasses can override this method to return sizes in
     * various units, usually bytes.
     *
     * @param item The item to get the size of.
     */
    protected fun getSize(item: VALUE?): Int {
        return 1
    }

    /**
     * A callback called whenever an item is evicted from the cache. Subclasses can override.
     *
     * @param key  The key of the evicted item.
     * @param item The evicted item.
     */
    protected fun onItemEvicted(key: KEY, item: VALUE?) {
        // optional override
    }

    /**
     * Returns true if there is a value for the given key in the cache.
     *
     * @param key The key to check.
     */

    @Synchronized
    operator fun contains(key: KEY): Boolean {
        return cache.containsKey(key)
    }

    /**
     * Returns the item in the cache for the given key or null if no such item exists.
     *
     * @param key The key to check.
     */
    @Synchronized
    operator fun get(key: KEY): VALUE? {
        return cache[key]
    }

    /**
     * Adds the given item to the cache with the given key and returns any previous entry for the
     * given key that may have already been in the cache.
     *
     *
     * If the size of the item is larger than the total cache size, the item will not be added to
     * the cache and instead [.onItemEvicted] will be called synchronously with
     * the given key and item.
     *
     * @param key  The key to add the item at.
     * @param item The item to add.
     */
    @Synchronized
    fun put(key: KEY, item: VALUE?): VALUE? {
        val itemSize = getSize(item)
        if (itemSize >= maxSize) {
            onItemEvicted(key, item)
            return null
        }

        if (item != null) {
            currentSize += itemSize.toLong()
        }
        val old = cache.put(key, item!!)
        if (old != null) {
            currentSize -= getSize(old).toLong()

            if (old != item) {
                onItemEvicted(key, old)
            }
        }
        evict()

        return old
    }

    /**
     * Removes the item at the given key and returns the removed item if present, and null otherwise.
     *
     * @param key The key to remove the item at.
     */
    @Synchronized
    fun remove(key: KEY): VALUE? {
        val value = cache.remove(key)
        if (value != null) {
            currentSize -= getSize(value).toLong()
        }
        return value
    }

    /**
     * Clears all items in the cache.
     */
    fun clearMemory() {
        trimToSize(0)
    }

    /**
     * Removes the least recently used items from the cache until the current size is less than the
     * given size.
     *
     * @param size The size the cache should be less than.
     */
    @Synchronized
    protected fun trimToSize(size: Long) {
        var last: MutableMap.MutableEntry<KEY, VALUE>
        var cacheIterator: MutableIterator<MutableMap.MutableEntry<KEY, VALUE>>
        while (currentSize > size) {
            cacheIterator = cache.entries.iterator()
            last = cacheIterator.next()
            val toRemove = last.value
            currentSize -= getSize(toRemove).toLong()
            val key = last.key
            cacheIterator.remove()
            onItemEvicted(key, toRemove)
        }
    }

    private fun evict() {
        trimToSize(maxSize)
    }
}