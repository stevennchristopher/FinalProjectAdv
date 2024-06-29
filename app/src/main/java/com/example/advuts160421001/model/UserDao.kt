package com.example.advuts160421001.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user:User)

    @Query("SELECT * FROM user WHERE id= :id")
    fun getUserDetail(id:Int): User

    @Query("SELECT * FROM user WHERE username= :username")
    fun cekUsername(username:String): User

    @Query("UPDATE user SET username=:username, email=:email, password=:password WHERE id = :id")
    fun update(username:String, email:String, password:String, id:Int)

    @Delete
    fun deleteUser(user:User)
}