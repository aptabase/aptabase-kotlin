package com.aptabase

import android.content.Context
import android.content.pm.ApplicationInfo
import android.os.Build
import java.util.*

data class EnvironmentInfo(
    var isDebug: Boolean = false,
    var osName: String = "",
    var osVersion: String = "",
    var locale: String = "",
    var appVersion: String = "",
    var appBuildNumber: String = ""
) {
    companion object {
        @Suppress("DEPRECATION")
        fun get(context: Context): EnvironmentInfo {
            var isDebug = 0 != context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            val appVersion = packageInfo.versionName
            val appBuildNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.longVersionCode.toString()
            } else {
                packageInfo.versionCode.toString()
            }

            return EnvironmentInfo(
                isDebug = isDebug,
                osName = "Android",
                osVersion = Build.VERSION.RELEASE ?: "",
                locale = Locale.getDefault().language,
                appVersion = appVersion ?: "",
                appBuildNumber = appBuildNumber
            )
        }
    }
}
