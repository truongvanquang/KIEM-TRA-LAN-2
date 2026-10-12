package com.example.kiemtralan2

import java.io.Serializable

class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false,
    var soLanChinhSua: Int = 0
) : Serializable {
    fun layThongTin(): String {
        val tt = if (trangThai) "Đã hoàn thành" else "Chưa hoàn thành"
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $tt\nSố lần sửa: $soLanChinhSua"
    }
}