package com.example.instagramalyysa

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramalyysa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val editProfileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // Tangkap nama dan bio baru
            val updatedName = result.data?.getStringExtra("EXTRA_NAMA")
            val updatedBio = result.data?.getStringExtra("EXTRA_BIO")

            if (!updatedName.isNullOrEmpty()) {
                binding.tvName.text = updatedName
            }
            if (!updatedBio.isNullOrEmpty()) {
                binding.tvBio.text = updatedBio // Set data ke TextView Bio
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol Edit Profile
        binding.btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            // Kirim nama dan bio saat ini ke EditProfileActivity
            intent.putExtra("EXTRA_NAMA", binding.tvName.text.toString())
            intent.putExtra("EXTRA_BIO", binding.tvBio.text.toString())
            editProfileLauncher.launch(intent)
        }

        // Tombol Foto Profil diklik (Detail Photo)
        binding.ivAvatar.setOnClickListener {
            val intent = Intent(this, DetailPhotoActivity::class.java)
            intent.putExtra("EXTRA_NAMA", binding.tvName.text.toString())
            intent.putExtra("EXTRA_IMAGE", R.drawable.max_pfp)
            startActivity(intent)
        }
    }
}