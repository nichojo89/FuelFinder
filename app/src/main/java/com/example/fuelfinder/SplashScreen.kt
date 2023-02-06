package com.example.fuelfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.google.android.libraries.places.api.Places

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }

    /**
     * Initialize app service on launch
     */
    private fun bootStrap(){
        // Initialize Google Places SDK
        Places.initialize(applicationContext, "AIzaSyCf0igQQ6pNQenVuAvkJU4pPmOiGHG5B80")
        val placesClient = Places.createClient(this)
    }
}