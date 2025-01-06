package com.apnamart.apnarider.core_app_framework.storage.file

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject


class FileHandler @Inject
constructor() {

    fun storeData(path: String, fileName: String, fileData: String) {
        try {
            val fileDr = File(path)
            if (!fileDr.exists()) {
                fileDr.mkdirs()
            }
            val createdFile = File(fileDr, fileName)
            FileOutputStream(createdFile).use { fos ->
                fos.write(fileData.toByteArray())
            }
        } catch (e: Exception) {
        }
    }

    fun getData(path: String, fileName: String): String? {
        return try {
            val file = File(path, fileName)
            if (file.exists()) {
                val data = file.readText()
                data
            } else {
                null
            }

        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

