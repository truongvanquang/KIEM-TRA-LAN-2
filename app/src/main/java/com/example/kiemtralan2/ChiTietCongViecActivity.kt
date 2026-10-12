package com.example.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityChiTietCongViecBinding

class ChiTietCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietCongViecBinding
    private var congViec: CongViec? = null

    private val editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            congViec?.tenCongViec = result.data?.getStringExtra("TEN_MOI") ?: ""
            congViec?.moTa = result.data?.getStringExtra("MOTA_MOI") ?: ""

            // Đề bổ sung: Tăng số lần chỉnh sửa lên 1 khi lưu thành công
            congViec?.soLanChinhSua = (congViec?.soLanChinhSua ?: 0) + 1

            hienThiDuLieu()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận Object CongViec
        congViec = intent.getSerializableExtra("CONG_VIEC") as? CongViec
        hienThiDuLieu()

        // Xử lý Checkbox trạng thái
        binding.cbTrangThai.setOnCheckedChangeListener { _, isChecked ->
            congViec?.trangThai = isChecked
            val tt = if (isChecked) "hoàn thành" else "chưa hoàn thành"
            Toast.makeText(this, "Đánh dấu: $tt", Toast.LENGTH_SHORT).show()
        }

        binding.btnChinhSua.setOnClickListener {
            val intentSua = Intent(this, ChinhSuaCongViecActivity::class.java)
            intentSua.putExtra("TEN_CU", congViec?.tenCongViec)
            intentSua.putExtra("MOTA_CU", congViec?.moTa)
            editLauncher.launch(intentSua)
        }
    }

    private fun hienThiDuLieu() {
        congViec?.let {
            binding.tvTenCongViec.text = "Tên: ${it.tenCongViec}"
            binding.tvMoTa.text = "Mô tả: ${it.moTa}"
            binding.cbTrangThai.isChecked = it.trangThai

            // Đề bổ sung: Hiển thị số lần chỉnh sửa ra màn hình
            binding.tvSoLanSua.text = "Số lần chỉnh sửa: ${it.soLanChinhSua}"
        }
    }
}