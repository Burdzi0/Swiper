package tech.burdzi0.swiper

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import com.squareup.picasso.Picasso

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imageView = findViewById<ImageView>(R.id.description)

        val builder = Picasso.Builder(this)
        builder.listener { _, _, exception ->
            exception.printStackTrace()
        }

        builder
            .build()
            .load("https://sesja.linuksowa.pl/img/logo-duze-pl.png")
            .into(imageView)

        findViewById<Button>(R.id.more).setOnClickListener{
            val intent = Intent(this, PagerActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.exit).setOnClickListener{
            this.finishAffinity()
        }

    }
}
