package com.aptabase.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.aptabase.Aptabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initButton: Button = findViewById(R.id.initButton)
        initButton.setOnClickListener {
            Aptabase.instance.initialize(this, "<api-key>")
        }

        val trackButton: Button = findViewById(R.id.trackButton)
        trackButton.setOnClickListener {
            Aptabase.instance.trackEvent("connect_click")
        }

        val trackPropertyButton: Button = findViewById(R.id.trackPropertyButton)
        trackPropertyButton.setOnClickListener {
            val map = mapOf<String, Any>(
                "with_love_from" to "NativeScript"
            )
            Aptabase.instance.trackEvent("hello", map)
        }
    }
}