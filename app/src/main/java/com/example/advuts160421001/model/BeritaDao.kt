package com.example.advuts160421001.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BeritaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg berita: Berita)

    @Query("SELECT b.id, b.judul, b.urlFoto, b.deskripsi, u.username as username_pembuat \n" +
            "  FROM berita as b \n" +
            "  INNER JOIN user as u ON b.user_id = u.id \n" +
            "  ORDER BY b.tanggalbuat DESC")
    fun getBerita()

    @Query("UPDATE berita SET judul=:judul, urlFoto=:urlFoto, deskripsi=:deskripsi WHERE id = :id")
    fun update(judul:String, urlFoto:String, deskripsi:String, id:Int)

    @Delete
    fun deleteUser(berita:Berita)
}