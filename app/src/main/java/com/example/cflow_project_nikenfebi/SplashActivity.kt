package com.example.cflow_project_nikenfebi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        /** kodingan untuk Splash Screen**/
        Handler().postDelayed({
            startActivity(Intent(this, OpeningSlide::class.java))
        },2000
        )
    }
}