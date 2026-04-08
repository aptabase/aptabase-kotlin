package com.aptabase

/**
 * Represents the tracking mode (release/debug) for the client.
 *
 * - [asDebug]: Track events as debug events.
 * - [asRelease]: Track events as release events.
 * - [readFromEnvironment]: Detect automatically from the app's build flags (default).
 */
enum class TrackingMode {
    asDebug,
    asRelease,
    readFromEnvironment
}
