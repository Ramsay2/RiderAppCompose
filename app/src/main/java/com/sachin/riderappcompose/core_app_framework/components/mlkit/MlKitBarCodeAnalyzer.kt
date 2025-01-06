package com.apnamart.apnarider.core_app_framework.components.mlkit

import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class MlKitBarCodeAnalyzer(val listener: ScanningResultListener) : ImageAnalysis.Analyzer {

    var isScanning: Boolean = false

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null && !isScanning) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val options = BarcodeScannerOptions.Builder()
                .setBarcodeFormats(
                    Barcode.FORMAT_EAN_13,
                    Barcode.FORMAT_EAN_8,
                    Barcode.FORMAT_CODE_128,
                    Barcode.FORMAT_CODE_93,
                    Barcode.FORMAT_CODE_39,
                    Barcode.FORMAT_UPC_A,
                    Barcode.FORMAT_UPC_E
                )
                .build()
            val scanner = BarcodeScanning.getClient(options)
            isScanning = true
            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    barcodes.firstOrNull().let { barcode ->
                        val rawValue = barcode?.displayValue
                        rawValue?.let {
                            listener.onScanned(it)
                        }
                    }
                }.addOnCompleteListener {
                    isScanning = false
                    imageProxy.close()
                }
        }
    }
}