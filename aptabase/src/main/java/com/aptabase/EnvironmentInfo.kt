package com.aptabase

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import java.util.*

data class EnvironmentInfo(
    var osName: String = "",
    var osVersion: String = "",
    var locale: String = "",
    var appVersion: String = "",
    var appBuildNumber: String = ""
) {
    companion object {
        fun get(context: Context): EnvironmentInfo {
            val packageManager = context.packageManager
            val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
            val appVersion = packageInfo.versionName
            val appBuildNumber = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                packageInfo.longVersionCode.toString()
            } else {
                @Suppress("DEPRECATION")
                packageInfo.versionCode.toString()
            }

            return EnvironmentInfo(
                osName = "Android",
                osVersion = Build.VERSION.RELEASE ?: "",
                locale = Locale.getDefault().language,
                appVersion = appVersion ?: "",
                appBuildNumber = appBuildNumber ?: ""
            )
        }
    }
}
