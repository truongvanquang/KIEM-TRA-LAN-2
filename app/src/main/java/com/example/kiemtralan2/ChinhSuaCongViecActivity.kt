package com.example.kiemtralan2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityChinhSuaCongViecBinding

class ChinhSuaCongViecActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChinhSuaCongViecBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaCongViecBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu cũ để hiển thị lên ô nhập
        binding.edtSuaTen.setText(intent.getStringExtra("TEN_CU"))
        binding.edtSuaMoTa.setText(intent.getStringExtra("MOTA_CU"))

        // Xử lý nút Lưu (Bắt lỗi bỏ trống)
        binding.btnLuu.setOnClickListener {
            val tenMoi = binding.edtSuaTen.text.toString().trim()
            val moTaMoi = binding.edtSuaMoTa.text.toString().trim()

            // Kiểm tra dữ liệu không hợp lệ (để trống)
            if (tenMoi.isEmpty()) {
                Toast.makeText(this, "Không được để trống tên công việc!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Trả về dữ liệu mới
            val intentKetQua = Intent()
            intentKetQua.putExtra("TEN_MOI", tenMoi)
            intentKetQua.putExtra("MOTA_MOI", moTaMoi)
            setResult(Activity.RESULT_OK, intentKetQua)
            finish()
        }

        // Xử lý nút Hủy (Hủy không cập nhật)
        binding.btnHuy.setOnClickListener {
            setResult(Activity.RESULT_CANCELED) // Trả về mã Hủy
            finish()
        }
    }
}