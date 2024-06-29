package com.example.advuts160421001.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ParagrafDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg paragraf: Paragraf)

    @Query("SELECT p.id, b.judul as judulBerita, b.urlFoto as urlFotoBerita, u.username as username_pembuat, p.subjudul, p.deskripsi\n" +
            "FROM paragraf as p\n" +
            "INNER JOIN berita as b ON p.berita_id = b.id\n" +
            "INNER JOIN user as u ON b.user_id = u.id\n" +
            "WHERE p.berita_id = :beritaId")
    fun getParagrafByBeritaId(beritaId: Int)

    @Query("UPDATE paragraf SET subjudul=:subjudul, deskripsi=:deskripsi WHERE id = :id")
    fun update(subjudul:String, deskripsi:String, id:Int)

    @Delete
    fun deleteUser(paragraf: Paragraf)
}