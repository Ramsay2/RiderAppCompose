package com.apnamart.apnarider.core_app_framework.retrofit.logger

enum class Level {
    /**
     * No logs.
     */
    NONE,
    /**
     *
     * Example:
     * <pre>`- BASE_URL
     * - Method
     * - Headers
     * - Body
    `</pre> *
     */
    BASIC,
    /**
     *
     * Example:
     * <pre>`- BASE_URL
     * - Method
     * - Headers
    `</pre> *
     */
    HEADERS,
    /**
     *
     * Example:
     * <pre>`- BASE_URL
     * - Method
     * - Body
    `</pre> *
     */
    BODY
}
