package com.example.instagramalyysa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iglocalapp.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Menerima data awal dari MainActivity jika ada
        val namaLama = intent.getStringExtra(MainActivity.EXTRA_NAMA)
        val bioLama = intent.getStringExtra(MainActivity.EXTRA_BIO)

        // Set teks awal pada EditText
        binding.edtNama.setText(namaLama)
        binding.edtBio.setText(bioLama)

        // 2. Event saat tombol Simpan diklik
        binding.btnSimpan.setOnClickListener {
            val namaBaru = binding.edtNama.text.toString()
            val bioBaru = binding.edtBio.text.toString()

            // Buat intent untuk membawa data kembali
            val resultIntent = Intent().apply {
                putExtra(MainActivity.EXTRA_NAMA, namaBaru)
                putExtra(MainActivity.EXTRA_BIO, bioBaru)
            }

            // Set result status OK dan kirim balik intent
            setResult(Activity.RESULT_OK, resultIntent)

            // Tutup EditProfileActivity
            finish()
        }
    }
}