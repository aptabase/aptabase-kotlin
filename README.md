![Aptabase](https://aptabase.com/og.png)

> **Warning**
> This package is still in progress and not yet published to any Maven repository.

# Kotlin SDK for Aptabase

Instrument your apps with Aptabase, an Open Source, Privacy-First and Simple Analytics for Mobile, Desktop and Web Apps.

## Install

Add the following dependency to your app `build.gradle` file:

```gradle
dependencies {
    implementation 'com.aptabase:aptabase:0.0.3'
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
        Aptabase.instance.initialize(context, "<YOUR_APP_KEY>"); // 👈 this is where you enter your App Key
    }
}
```

Afterwards you can start tracking events with `trackEvent`:

```kotlin
import com.aptabase.Aptabase

Aptabase.instance.trackEvent("connect_click"); // An event with no properties
Aptabase.instance.trackEvent("play_music", mapOf<String, Any>( // An event with a custom property
        "name" to "here_comes_the_sun" )
    ) 
```

A few important notes:

1. The SDK will automatically enhance the event with some useful information, like the OS, the app version, and other things.
2. You're in control of what gets sent to Aptabase. This SDK does not automatically track any events, you need to call `trackEvent` manually.
   - Because of this, it's generally recommended to at least track an event at startup
3. The `trackEvent` function is a non-blocking operation as it runs on the background.
4. Only strings and numbers values are allowed on custom properties