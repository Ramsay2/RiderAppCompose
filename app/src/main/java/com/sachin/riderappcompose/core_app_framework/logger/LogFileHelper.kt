package com.apnamart.apnarider.core_app_framework.logger

import android.app.Application
import android.util.Log
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LogFileHelper(application: Application) {

    private val logDirectoryName: String = "${application.filesDir.absolutePath}${File.separator}logs"

    private var logDirectory: File = File(logDirectoryName)
    private var eventLogFile: File
    private var debugLogFile: File
    private var apiLogFile: File

    private val debugLogWritingPool: ExecutorService = Executors.newSingleThreadExecutor()
    private val apiLogWritingPool: ExecutorService = Executors.newSingleThreadExecutor()
    private val eventLogWritingPool: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        if (!logDirectory.exists())
            logDirectory.mkdirs()
        this.eventLogFile = File(logDirectory, "event.log")
        this.debugLogFile = File(logDirectory, "debug.log")
        this.apiLogFile = File(logDirectory, "api.log")
    }

    fun writeLog(log: String) {
        debugLogWritingPool.submit(LogFileWriter(debugLogFile, log))
    }

    fun writeApiLog(log: String) {
        apiLogWritingPool.submit(LogFileWriter(apiLogFile, log))
    }

    fun writeEventLog(log: String) {
        eventLogWritingPool.submit(LogFileWriter(eventLogFile, log))
    }

    internal inner class LogFileWriter(private val file: File, private val logBuffer: String) : Runnable {

        override fun run() {
            try {
                if (!file.exists())
                    file.createNewFile()
                val writer = FileWriter(file, true)
                writer.append(logBuffer)
                writer.append("\n")
                writer.flush()
                writer.close()
            } catch (e: IOException) {
                Log.e(TAG, "Error while writing log on File: ${file.absolutePath}", e)
            }
        }
    }

    companion object {
        const val TAG: String = "LogFileHelper"
    }
}
