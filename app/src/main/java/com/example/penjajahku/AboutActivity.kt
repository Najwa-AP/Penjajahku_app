package com.example.penjajahku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

class AboutActivity : AppCompatActivity() {
       private lateinit var aboutTitle : TextView
       private lateinit var aboutPic : ImageView
       private lateinit var aboutName : TextView
       private lateinit var aboutEmail : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_detail)

        aboutTitle = findViewById(R.id.about_title)
        aboutPic = findViewById(R.id.about_image)
        aboutName = findViewById(R.id.about_name)
        aboutEmail = findViewById(R.id.about_email)

        val IMAGE = intent.getIntExtra(ABOUT_IMAGE, -1)

        val TITLE = getString(R.string.title)
        val NAME = getString(R.string.name)
        val EMAIL = getString(R.string.email)

        aboutTitle.text = TITLE
        aboutName.text = NAME
        aboutEmail.text = EMAIL

        if (IMAGE != -1) {
            Glide.with(this)
                 .load(R.drawable.pic)
                 .transform(CircleCrop())
                 .into(aboutPic)
        } else {
            Toast.makeText(this, "foto profil tidak tersedia", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val ABOUT_TITLE = "about_title"
        const val ABOUT_IMAGE = "about_image"
        const val ABOUT_NAME = "about_name"
        const val ABOUT_EMAIL = "about_email"
    }
}