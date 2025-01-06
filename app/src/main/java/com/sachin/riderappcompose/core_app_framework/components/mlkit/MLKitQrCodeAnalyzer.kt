package com.apnamart.apnarider.core_app_framework.components.mlkit

import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class MLKitQrCodeAnalyzer(val listener: ScanningResultListener) : ImageAnalysis.Analyzer {

    var isScanning: Boolean = false

    @ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null && !isScanning) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val options = BarcodeScannerOptions.Builder()
                    .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
                    .build()
            val scanner = BarcodeScanning.getClient(options)

            scanner.process(image)
                    .addOnSuccessListener { barcodes ->
                        imageProxy.close()
                        barcodes.firstOrNull().let { barcode ->
                            val rawValue = barcode?.rawValue
                            rawValue?.let {
                                isScanning = true
                                listener.onScanned(it)
                            }
                        }
                    }
                    .addOnFailureListener {
                        isScanning = false
                        imageProxy.close()
                    }
        }
    }
}