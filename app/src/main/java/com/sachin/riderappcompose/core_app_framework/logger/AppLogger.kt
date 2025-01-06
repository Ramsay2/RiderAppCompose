package com.apnamart.apnarider.core_app_framework.logger

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

import java.io.PrintWriter
import java.io.StringWriter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AppLogger {

    /* Companion Object for Static Fields */
    companion object {
        private const val LOG_TAG = "AppLogger"
        private const val FIREBASE_MAX_SESSION_DURATION = 15 * 60 * 1000 // Time in millis

        private var isFileLoggingEnable = false
        private var isLogcatEnabled = true
        private var isInitialized: Boolean = false

   /*     lateinit var firebaseAnalytics: FirebaseAnalytics
        private lateinit var crashlytics: FirebaseCrashlytics*/

        private lateinit var logFileHelper: LogFileHelper

       fun initialize(application: Application) {
//            FirebaseApp.initializeApp(application)
//            firebaseAnalytics = Firebase.analytics.apply {
//                setAnalyticsCollectionEnabled(true)
//                setSessionTimeoutDuration(FIREBASE_MAX_SESSION_DURATION.toLong())
//            }
//            crashlytics = Firebase.crashlytics.apply {
//                setCrashlyticsCollectionEnabled(true)
//            }
            logFileHelper = LogFileHelper(application)
            isInitialized = true
        }

        fun canLogEvent() : Boolean {
            return isInitialized
        }

        fun enableLogcat(isLogcatEnable: Boolean) {
            isLogcatEnabled = isLogcatEnable
        }

        fun enableFileLogging(doLogFile: Boolean) {
            isFileLoggingEnable = doLogFile
        }

        private val logSpecificDetails: String?
            get() {
                try {
                    val className = Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].className
                    return "(${Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].fileName}" +
                            ":${Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].lineNumber}" +
                            ")$${className.substring(className.lastIndexOf(".") + 1)}" +
                            "#${Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].methodName}" +
                            "[${Thread.currentThread().name}]"
                } catch (ex: Exception) {
                    Log.e(LOG_TAG, ex.message, ex)
                }
                return null
            }

        private val tag: String?
            get() {
                try {
                    return "(${Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].fileName}" +
                            ":${Thread.currentThread().stackTrace[LoggerDepth.ACTUAL_METHOD].lineNumber})"
                } catch (ex: Exception) {
                    Log.e(LOG_TAG, ex.message, ex)
                }
                return null
            }

        private val getTabs: String
            get() {
                val stringBuilder = StringBuilder()
                for (i in 0 until 60) {
                    stringBuilder.append("&nbsp;")
                }
                return stringBuilder.toString()
            }

        private val timeStamp: String
            get() {
                return SimpleDateFormat("dd-MMM-yyyy HH:mm:ssS a Z", Locale.getDefault()).format(Calendar.getInstance().timeInMillis)
            }


        fun verbose(message: String) {
            processLog(LogType.V, message, null, LogFileType.DEBUG_LOG)
        }

        fun verbose(throwable: Throwable, message: String) {
            processLog(LogType.V, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun debug(message: String) {
            processLog(LogType.D, message, null, LogFileType.DEBUG_LOG)
        }

        fun debug(throwable: Throwable, message: String) {
            processLog(LogType.D, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun warn(message: String) {
            processLog(LogType.W, message, null, LogFileType.DEBUG_LOG)
        }

        fun warn(throwable: Throwable, message: String) {
            processLog(LogType.W, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun error(message: String) {
            processLog(LogType.E, message, null, LogFileType.DEBUG_LOG)
        }

        fun error(throwable: Throwable, message: String) {
            processLog(LogType.E, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun info(message: String) {
            processLog(LogType.I, message, null, LogFileType.DEBUG_LOG)
        }

        fun info(throwable: Throwable, message: String) {
            processLog(LogType.I, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun wtf(message: String) {
            processLog(LogType.WTF, message, null, LogFileType.DEBUG_LOG)
        }

        fun wtf(throwable: Throwable, message: String) {
            processLog(LogType.WTF, message, throwable, LogFileType.DEBUG_LOG)
        }

        fun event(eventCategory: String, key: String, eventData: String) {
//            if (isInitialized) {
//                firebaseAnalytics.logEvent(eventCategory) {
//                    param(key, eventData)
//                }
//            }
            processLog(LogType.I, "Event: ${eventCategory}; Event Data: $eventData;", null, LogFileType.EVENT_LOG)
        }

        fun event(eventCategory: String) {
//            if (isInitialized) {
//                firebaseAnalytics.logEvent(eventCategory) {}
//            }
            processLog(LogType.I, "Event: ${eventCategory};", null, LogFileType.EVENT_LOG)
        }

        fun event(eventCategory: String, bundle: Bundle?) {
//            if (isInitialized) {
//                firebaseAnalytics.logEvent(eventCategory, bundle)
//            }
            processLog(LogType.I, "Event: ${eventCategory}; Event Data: $bundle;", null, LogFileType.EVENT_LOG)
        }

        fun setUserId(userId: String) {
//            if (isInitialized) {
//                firebaseAnalytics.setUserId(userId)
//                crashlytics.setUserId(userId)
//            }
            processLog(LogType.I, "User-$userId Added;", null, LogFileType.EVENT_LOG)
        }

        fun setDefaultParams(params: Bundle) {
//            if (isInitialized) {
//                firebaseAnalytics.setDefaultEventParameters(params)
//            }
        }

        fun setUserProperty(userProperty: String, propertyData: String) {
//            if (isInitialized) {
//                firebaseAnalytics.setUserProperty(userProperty, propertyData)
//                crashlytics.setCustomKeys {
//                    key(userProperty, propertyData)
//                }
//            }
            processLog(LogType.I, "User Property - $userProperty : $propertyData Added;", null, LogFileType.EVENT_LOG)
        }

        fun setCurrentScreen(activity: Activity, screenName: String) {
//            if (isInitialized)
//                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
//                    putString("screen_name", screenName) })
            processLog(LogType.I, "Current Activity: ${activity.javaClass.simpleName}; Current Screen: $screenName Added;", null, LogFileType.EVENT_LOG)
        }

        fun apiLog(log: String) {
            processLog(LogType.I, "Request Received from Interceptor:\n$log", null, LogFileType.API_LOG)
        }

        fun mqttLog(log: String) {
            processLog(LogType.I, log, null, LogFileType.MQTT_LOG)
        }

        fun recordException(error: Throwable) {
//            if (isInitialized)
//                crashlytics.recordException(error)
        }

        private fun processLog(logType: String, message: String, throwable: Throwable?, logFileType: String) {
            var log: String
            try {
                log = if (logFileType == LogFileType.API_LOG || logFileType == LogFileType.MQTT_LOG)
                    message
                else
                    "$timeStamp$logType $logSpecificDetails $message ${getStackTraceString(throwable)}"
                if (isInitialized && isFileLoggingEnable)
                    when (logFileType) {
                        LogFileType.API_LOG -> logFileHelper.writeApiLog(log)
                        LogFileType.DEBUG_LOG -> logFileHelper.writeLog(log)
                        LogFileType.EVENT_LOG -> logFileHelper.writeEventLog(log)
                        LogFileType.MQTT_LOG -> logFileHelper.writeEventLog(log)
                    }
                if (isLogcatEnabled)
                    when (logType) {
                        LogType.V -> Log.v(tag, message, throwable)
                        LogType.I -> {
                            if (logFileType == LogFileType.API_LOG)
                                Log.i(LOG_TAG, message)
                            else
                                Log.i(tag, message, throwable)
                        }
                        LogType.D -> Log.d(tag, message, throwable)
                        LogType.W -> Log.w(tag, message, throwable)
                        LogType.E -> Log.e(tag, message, throwable)
                        LogType.WTF -> Log.wtf(tag, message, throwable)
                    }
            } catch (exception: Exception) {
                Log.e(LOG_TAG, "AppLogger failed, exception: " + exception.message)

                log = "$timeStamp${LogType.E} $logSpecificDetails AppLogger failed, exception: ${getStackTraceString(throwable)}"
                if (isInitialized && isFileLoggingEnable)
                    when (logFileType) {
                        LogFileType.API_LOG -> logFileHelper.writeApiLog(log)
                        LogFileType.DEBUG_LOG -> logFileHelper.writeLog(log)
                        LogFileType.EVENT_LOG -> logFileHelper.writeEventLog(log)
                        LogFileType.MQTT_LOG -> logFileHelper.writeEventLog(log)
                    }
            }
            if (!isInitialized)
                Log.e(LOG_TAG, "AppLogger Not Initialized, Please Initialize on Application class")
        }

        private fun getStackTraceString(tr: Throwable?): String {
            if (tr == null) {
                return ""
            }
            val sw = StringWriter()
            val pw = PrintWriter(sw)
            tr.printStackTrace(pw)
            pw.flush()
            return sw.toString()
        }
    }

    internal class LogFileType {
        companion object {
            const val DEBUG_LOG = "DEBUG_LOG"
            const val EVENT_LOG = "EVENT_LOG"
            const val API_LOG = "API_LOG"
            const val MQTT_LOG = "MQTT_LOG"
        }
    }

    internal class LogType {
        companion object {
            const val D = " D/: "
            const val E = " E/: "
            const val I = " I/: "
            const val V = " V/: "
            const val W = " W/: "
            const val WTF = " WTF/: "
        }
    }

    internal class LoggerDepth {
        companion object {
            const val ACTUAL_METHOD = 5
            const val LOGGER_METHOD = 3
            const val STACK_TRACE_METHOD = 1
            const val JVM_METHOD = 0
        }
    }
}
