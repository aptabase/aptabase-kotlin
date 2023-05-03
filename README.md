![Aptabase](https://aptabase.com/og.png)

# Kotlin SDK for Aptabase

<!-- [![](https://img.shields.io/endpoint?url=https%3A%2F%2Fswiftpackageindex.com%2Fapi%2Fpackages%2Faptabase%2Faptabase-swift%2Fbadge%3Ftype%3Dswift-versions)](https://swiftpackageindex.com/aptabase/aptabase-swift)
[![](https://img.shields.io/endpoint?url=https%3A%2F%2Fswiftpackageindex.com%2Fapi%2Fpackages%2Faptabase%2Faptabase-swift%2Fbadge%3Ftype%3Dplatforms)](https://swiftpackageindex.com/aptabase/aptabase-swift) -->


Instrument your apps with Aptabase, an Open Source, Privacy-First and Simple Analytics for Mobile, Desktop and Web Apps.

## Install

Add the following dependency to your app's build.gradle file:

```gradle
dependencies {
    implementation 'com.aptabase:aptabase:0.0.1'
}
```

## Usage

First you need to get your `App Key` from Aptabase, you can find it in the `Instructions` menu on the left side menu.

Initialized the SDK as early as possible in your app, for example:

```kotlin
import com.aptabase.Aptabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // ...
        val context = this
        Aptabase.shared.initialize(context, "<api-key>")
    }
}
```

Afterwards you can start tracking events with `trackEvent`:

```kotlin
import com.aptabase.Aptabase

Aptabase.shared.trackEvent("connect_click"); // An event with no properties
Aptabase.shared.trackEvent("play_music", mapOf<String, Any>( // An event with a custom property
        "name" to "here_comes_the_sun" )
    ) 
```

A few important notes:

1. The SDK will automatically enhance the event with some useful information, like the OS, the app version, and other things.
2. You're in control of what gets sent to Aptabase. This SDK does not automatically track any events, you need to call `trackEvent` manually.
   - Because of this, it's generally recommended to at least track an event at startup
3. The `trackEvent` function is a non-blocking operation as it runs on the background.
4. Only strings and numbers values are allowed on custom properties