package com.apnamart.apnarider.core_app_framework

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.*
import android.location.Location
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Base64
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import androidx.camera.core.ImageProxy
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.apnamart.apnarider.core_app_framework.utility.datetime.getCurrentTimeLong
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.*
import java.text.DecimalFormat
import java.util.Calendar
import java.util.Locale
import java.util.UUID
import java.util.regex.Pattern
import kotlin.math.roundToInt


typealias BASE64_STRING = String

fun parseOneTimeCode(message: String?): String? {
    val p = Pattern.compile("(|^)\\d{6}")
    val m = p.matcher(message ?: "")
    return if (m.find()) m.group(0) else ""
}

fun NavController.navigateSafe(
    @IdRes resId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(resId, args, navOptions, navExtras)
    }
}

fun loadBitmapFromView(view: View): Bitmap {
    val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(returnedBitmap)
    val bgDrawable = view.background
    if (bgDrawable != null)
        bgDrawable.draw(canvas)
    else
        canvas.drawColor(Color.TRANSPARENT)
    view.draw(canvas)
    return returnedBitmap
}

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    resolveRefs: Boolean = true
): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

@StyleRes
fun Context.getStyleFromAttr(
    @AttrRes attrStyle: Int,
    resolveRefs: Boolean = true
): Int {
    val typedValue = TypedValue()
    theme.resolveAttribute(attrStyle, typedValue, resolveRefs)
    return typedValue.data
}

fun DialogFragment.setWidthPercent(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun DialogFragment.setHeightWidthPercent(percentage: Int) {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    val percentWidth = rect.width() * percent
    val percentHeight = rect.height() * percent
    dialog?.window?.setLayout(percentWidth.toInt(), percentHeight.toInt())
}

/**
 * Call this method (in onActivityCreated or later)
 * to make the dialog near-full screen.
 */
fun DialogFragment.setFullScreen() {
    dialog?.window?.setLayout(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT
    )
}


//fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
//    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
//    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
//    return layoutManager.getPosition(snapView)
//}

@Throws(IOException::class)
fun createImageFile(context: Context): File? {
    val timeStamp = System.currentTimeMillis().toString()
    val imageFileName = "JPEG_" + timeStamp + "_"
    val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
    val image = File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        storageDir      /* directory */
    )
    return image
}

fun File.copyInputStreamToFile(inputStream: InputStream) {
    inputStream.use { input ->
        this.outputStream().use { fileOut ->
            input.copyTo(fileOut)
        }
    }
}

fun getBarCodeList(barCode: String?, barCodes: List<String?>?): List<String> {
    val finalCodes = mutableListOf<String>()
    barCode?.let {
        if (it.isNotBlank())
            finalCodes.add(it)
    }
    barCodes?.forEach {
        val str = it?.trim()
        if (!str.isNullOrBlank())
            finalCodes.add(str)
    }
    return finalCodes.distinct()
}

fun Uri.uriToBitmap(context: Context): Bitmap {
    return MediaStore.Images.Media.getBitmap(context.contentResolver, this)
}

fun ImageProxy.convertImageProxyToBitmap(): Bitmap {
    val buffer = planes[0].buffer
    buffer.rewind()
    val bytes = ByteArray(buffer.capacity())
    buffer.get(bytes)
    val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    val matrix = Matrix().apply { postRotate(270f) }
    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
}

fun convertBitmapToFile(
    context: Context,
    fileName: String,
    bitmap: Bitmap,
    quality: Int = 50
): File {

    val file = File(context.cacheDir, "$fileName.jpg").apply { createNewFile() }

    try {
        FileOutputStream(file).use { fos ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fos)
            fos.flush()
        }
    } catch (e: Exception) {
//        ApnaRider.eventHub.recordError(e)
    }
    return file
}

fun HashMap<String, Any>.toBundle(): Bundle {
    val bundleData = Bundle()
    this.forEach { data ->
        if (data.value is Array<*>) {
            val arrayData = data.value as Array<HashMap<String, Any>>
            arrayData.map {
                it.forEach { map ->
                    bundleData.putString(map.key, map.value.toString())
                }

            }
        } else {
            bundleData.putString(data.key, data.value.toString())
        }
    }
    return bundleData
}

fun Activity.setStatusBarColor(color: Int) {
    var flags = window?.decorView?.systemUiVisibility // get current flag
    if (flags != null) {
        if (isColorDark(color)) {
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            window?.decorView?.systemUiVisibility = flags
        } else {
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window?.decorView?.systemUiVisibility = flags
        }
    }
    window?.statusBarColor = color
}

fun Activity.isColorDark(color: Int): Boolean {
    val darkness =
        1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255
    return darkness >= 0.5
}

fun Location.toDistance(lat: Double, lng: Double): Float {
    val location = Location("")
    location.latitude = lat
    location.longitude = lng
    return this.distanceTo(location)
}

fun Map<String, String>.toIntent(): Intent {
    val intent = Intent()
    this.forEach {
        intent.putExtra(it.key, it.value)
    }
    return intent
}

fun BASE64_STRING.toBitMap(): Bitmap {
    val decodedString: ByteArray = Base64.decode(this, Base64.DEFAULT)
    return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
}

inline fun <reified T : Parcelable> Bundle.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelable(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelable(key) as? T
}


fun Uri?.toMultipartBody(
    context: Context,
    fileName: String = "${getCurrentTimeLong()}",
    formFileName: String = "file",
    quality: Int = 50
): MultipartBody.Part? {
    try {
        val bitmap =
            this?.uriToBitmap(context)?.scalePreservingAspectRatio(1080)
        if (bitmap != null) {
            val file = convertBitmapToFile(context, fileName, bitmap, quality)
            val requestBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
            return MultipartBody.Part.createFormData(formFileName, file.name, requestBody)
        }
        return null
    } catch (e: Exception) {
//        ApnaRider.eventHub.recordError(e)
        return null
    }
}

fun Bitmap.rotateBitmap(rotation: Int): Bitmap {
    val matrix = Matrix().apply { postRotate(rotation.toFloat()) }
    return Bitmap.createBitmap(this, 0, 0, this.width, this.height, matrix, true)
}

fun Bitmap.scalePreservingAspectRatio(targetWidth: Int): Bitmap {
    val aspectRatio = this.height.toFloat() / this.width
    val targetHeight = (targetWidth * aspectRatio).toInt()
    return Bitmap.createScaledBitmap(this, targetWidth, targetHeight, true)
}

fun Double.toUpToTwoDecimal(): Double {
    return String.format("%.2f", this).toDouble()
}

fun Double.toUpToThreeDecimal(): Double {
    return DecimalFormat("#.###").format(this).toDouble()
}

fun Double.formatToDecimalString(): String {
    if (this % 1.0 == 0.0) {
        return this.toInt().toString()
    }

    return "%.3f".format(this).trimEnd('0').trimEnd('.')
}

fun Long.toCurrencyFormat(): String {
    return java.text.NumberFormat.getIntegerInstance(Locale("en", "in")).format(this)
}

fun Double.toCurrencyFormat(): String {
    val number = if (this % 1 == 0.0) {
        this.roundToInt()
    } else {
        this.toUpToTwoDecimal()
    }
    return java.text.NumberFormat.getNumberInstance(Locale("en", "in")).format(number)
}

fun String.toBase64(): String {
    return String(Base64.encode(this.toByteArray(), Base64.DEFAULT))
}

fun createLocation(provider: String, lat: Double, long: Double): Location {
    val location = Location(provider)
    location.latitude = lat
    location.longitude = long
    return location
}

fun getDeviceUniqueId(encodeStringToBase64: Boolean): String {
    val uniqueId =
        "${Calendar.getInstance().time.time}_${UUID.randomUUID()}_${Build.MANUFACTURER}_${Build.MODEL}"
    return if (encodeStringToBase64) {
        uniqueId.toBase64()
    } else {
        uniqueId
    }
}
