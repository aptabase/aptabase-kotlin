## 0.1.0

* Compile the library against API level 37 (Android 17) — fixes #13
* Upgrade the build toolchain to Android Gradle Plugin 9.4.1 and Gradle 9.6.1, using AGP's built-in Kotlin support (Kotlin stdlib 2.2)
* Consuming apps do not need to raise their own `compileSdk`; `minSdk` 16 is still supported

## 0.0.9

* Add `trackingMode` to `InitOptions` to force debug or release event tracking
* Add `appVersion` to `InitOptions` to override the reported app version

## 0.0.8

* Fix JitPack build

## 0.0.7

* Migration to JitPack.io
* Add `deviceModel`
* improve documentation

## 0.0.6

* Added support for automatic segregation of Debug/Release events

## 0.0.5

* Ability to set custom hosts for self hosted servers
