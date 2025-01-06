package com.apnamart.apnarider.data.files

interface FileHelper {
    fun getData(path: String, fileName: String): String?
    fun storeData(path: String, fileName: String, fileData: String)
}
