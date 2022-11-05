package com.example.appsepatu.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize



@Entity(tableName = "tbl_appsepatu")
@Parcelize
data class ModelDatabase(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "nama_pengguna")
    var namaPengguna: String,

    @ColumnInfo(name = "jenis_sepatu")
    var jenisSepatu: String,`

    @ColumnInfo(name = "berat")
    var jumlah: Int = 0,

    @ColumnInfo(name = "harga")
    var harga: Int = 0,

    @ColumnInfo(name = "tanggal")
    var tanggal: String,

    @ColumnInfo(name = "alamat")
    var alamat: String,

    @ColumnInfo(name = "catatan")
    var catatan: String

) : Parcelable
