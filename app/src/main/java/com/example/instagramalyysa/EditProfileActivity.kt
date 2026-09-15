package com.example.instagramalyysa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramalyysa.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaLama = intent.getStringExtra("EXTRA_NAMA")
        val bioLama = intent.getStringExtra("EXTRA_BIO")

        binding.etName.setText(namaLama)
        binding.etBio.setText(bioLama)

        binding.btnSave.setOnClickListener {
            val updatedName = binding.etName.text.toString()
            val updatedBio = binding.etBio.text.toString()

            val resultIntent = Intent().apply {
                putExtra("EXTRA_NAMA", updatedName)
                putExtra("EXTRA_BIO", updatedBio)
            }

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}