package com.example.advuts160421001.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CekUser(
    val result:String?,
    val id:String?
)

data class CekUsername(
    val result:String?
)

data class CekRegister(
    val result:String?
)

@Entity
data class User(
    @ColumnInfo(name="username")
    val username:String?,
    @ColumnInfo(name="email")
    val email:String?,
    @ColumnInfo(name="password")
    val password:String?
    ){
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
}

data class CekUpdateUser(
    val result:String?
)

data class Berita(
    val id: String?,
    val judul: String?,
    val urlFoto: String?,
    val deskripsi: String?,
    val username_pembuat: String?
)

data class Paragraf(
    val id: String?,
    val judulBerita: String?,
    val urlFotoBerita: String?,
    val username_pembuat: String?,
    val subjudul: String?,
    val deskripsi: String?
)