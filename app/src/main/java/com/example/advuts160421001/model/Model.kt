package com.example.advuts160421001.model

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

data class User(
    val id:String?,
    val username:String?,
    val nama_depan:String?,
    val nama_belakang:String?,
    val email:String?,
    val password:String?
)

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