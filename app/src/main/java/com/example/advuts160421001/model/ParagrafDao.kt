package com.example.advuts160421001.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ParagrafDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(pargrafs: List<Paragraf>)

    @Query("SELECT p.id, p.berita_id as beritaId, b.judul as judulBerita, b.urlFoto as urlFotoBerita, u.username as username_pembuat, p.subjudul, p.deskripsi " +
            "FROM Paragraf as p " +
            "INNER JOIN Berita as b ON p.berita_id = b.id " +
            "INNER JOIN User as u ON b.user_id = u.id " +
            "WHERE p.berita_id = :beritaId")
    fun selectParagrafByBeritaId(beritaId: Int): List<ParagrafWithDataBeritaDanUser>

    @Query("UPDATE paragraf SET subjudul=:subjudul, deskripsi=:deskripsi WHERE id = :id")
    fun update(subjudul:String, deskripsi:String, id:Int)

    @Delete
    fun deleteUser(paragraf: Paragraf)
}