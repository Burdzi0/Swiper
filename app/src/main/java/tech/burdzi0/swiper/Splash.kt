package tech.burdzi0.swiper

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

class Splash : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        Handler().postDelayed({
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this@Splash, Main::class.java)
            this@Splash.startActivity(mainIntent)
            this@Splash.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }

}
