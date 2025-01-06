package com.apnamart.apnarider.data.files

import com.apnamart.apnarider.core_app_framework.ioc.scope.ApplicationScope
import com.apnamart.apnarider.core_app_framework.storage.file.FileHandler
import javax.inject.Inject


class FileHelperImpl @Inject
constructor(private val fileHandler: FileHandler) : FileHelper {

    override fun getData(path: String, fileName: String): String? {
        return fileHandler.getData(
            path, fileName
        )
    }

    override fun storeData(path: String, fileName: String, fileData: String) {
        return fileHandler.storeData(path, fileName, fileData)
    }
}
