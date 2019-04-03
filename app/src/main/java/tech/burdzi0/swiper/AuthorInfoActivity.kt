package tech.burdzi0.swiper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class AuthorInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_info)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val builder = Picasso.Builder(this)
        builder.listener { _, _, exception ->
            exception.printStackTrace()
        }

        builder
            .build()
            .load("https://avatars1.githubusercontent.com/u/16168189?s=460&v=4")
            .into(imageView)
    }
}
