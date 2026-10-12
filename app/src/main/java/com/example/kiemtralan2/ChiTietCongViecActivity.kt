package com.example.kiemtralan2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận và hiển thị dữ liệu
        val ten = intent.getStringExtra("TEN_CV") ?: "Chưa có tên"
        val moTa = intent.getStringExtra("MO_TA_CV") ?: "Chưa có mô tả"

        binding.tvTenCongViec.text = "Tên: $ten"
        binding.tvMoTa.text = "Mô tả: $moTa"
    }
}