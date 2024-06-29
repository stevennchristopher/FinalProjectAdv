package com.example.advuts160421001.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//data class CekUser(
//    val result:String?,
//    val id:String?
//)

//data class CekUsername(
//    val result:String?
//)

//data class CekRegister(
//    val result:String?
//)

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name="username")
    val username:String?,
    @ColumnInfo(name="email")
    val email:String?,
    @ColumnInfo(name="password")
    val password:String?
)

//data class CekUpdateUser(
//    val result:String?
//)

@Entity
data class Berita(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name="judul")
    val judul: String?,
    @ColumnInfo(name="urlFoto")
    val urlFoto: String?,
    @ColumnInfo(name="deskripsi")
    val deskripsi: String?,
    @ColumnInfo(name="tanggalbuat")
    val tanggalbuat: Long?,
    @ColumnInfo(name="user_id")
    val username_pembuat: String?
)

@Entity
data class Paragraf(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name="subjudul")
    val subjudul: String?,
    @ColumnInfo(name="deskripsi")
    val deskripsi: String?,
    @ColumnInfo(name="berita_id")
    val beritaId: Int? = null
)