package com.example.instagramalyysa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramalyysa.databinding.ActivityDetailPhotoBinding

class DetailPhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaAkun = intent.getStringExtra("EXTRA_NAMA")
        val imageResId = intent.getIntExtra("EXTRA_IMAGE", 0)

        binding.tvDetailNama.text = namaAkun
        if (imageResId != 0) {
            binding.ivDetailPhoto.setImageResource(imageResId)
        }

        binding.btnKembali.setOnClickListener {
            finish()
        }
    }
}