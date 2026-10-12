package com.example.kiemtralan2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kiemtralan2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTaoCongViec.setOnClickListener {
            val ten = binding.edtTenCongViec.text.toString().trim()
            val moTa = binding.edtMoTa.text.toString().trim()

            // Câu 5: Bắt lỗi không để trống tên
            if (ten.isEmpty()) {
                Toast.makeText(this, "Không được để trống tên công việc!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Câu 4: Đóng gói vào Object CongViec
            val cv = CongViec(ten, moTa, false)

            val intent = Intent(this, ChiTietCongViecActivity::class.java)
            intent.putExtra("CONG_VIEC", cv)
            startActivity(intent)
        }
    }
}