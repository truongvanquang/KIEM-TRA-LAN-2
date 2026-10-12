package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTaoCongViec.setOnClickListener {
            val ten = binding.edtTenCongViec.text.toString()
            val moTa = binding.edtMoTa.text.toString()

            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("TEN_CV", ten)
            intent.putExtra("MO_TA_CV", moTa)
            startActivity(intent)
        }
    }
}