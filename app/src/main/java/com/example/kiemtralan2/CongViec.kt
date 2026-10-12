package com.example.kiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) : Serializable {
    fun layThongTin(): String {
        val tt = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $tt"
    }
}