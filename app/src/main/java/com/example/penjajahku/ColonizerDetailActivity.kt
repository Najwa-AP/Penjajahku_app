package com.example.penjajahku

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class ColonizerDetailActivity : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colonizer_detail)

        tvImage = findViewById(R.id.tv_image)
        tvName = findViewById(R.id.tv_name)
        tvDescription = findViewById(R.id.tv_description)

        val image = intent.getStringExtra(EXTRA_IMAGE)
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)

        tvName.text = name ?: "Nama tidak tersedia"
        tvDescription.text = description ?: "Deskripsi tidak tersedia"

        if (image != null) {
            Glide.with(this)
                 .load(image)
                .transform(RoundedCorners(15))
                 .into(tvImage)
        } else {
            Toast.makeText(this, "Image tidak tersedia", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
    }
}