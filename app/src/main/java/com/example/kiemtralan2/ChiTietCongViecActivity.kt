package com.example.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding

    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val newTen = result.data?.getStringExtra("TEN_MOI")
            val newMoTa = result.data?.getStringExtra("MOTA_MOI")
            if (newTen != null) binding.tvTenCongViec.text = "Tên: $newTen"
            if (newMoTa != null) binding.tvMoTa.text = "Mô tả: $newMoTa"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ten = intent.getStringExtra("TEN_CV") ?: ""
        val moTa = intent.getStringExtra("MO_TA_CV") ?: ""

        binding.tvTenCongViec.text = "Tên: $ten"
        binding.tvMoTa.text = "Mô tả: $moTa"

        binding.btnChinhSua.setOnClickListener {
            val intentSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentSua.putExtra("TEN_CU", binding.tvTenCongViec.text.toString().removePrefix("Tên: "))
            intentSua.putExtra("MOTA_CU", binding.tvMoTa.text.toString().removePrefix("Mô tả: "))
            editLauncher.launch(intentSua)
        }
    }
}