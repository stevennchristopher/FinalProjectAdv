package com.example.advuts160421001.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.advuts160421001.model.User
import com.example.todoapp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserViewModel(application: Application): AndroidViewModel(application), CoroutineScope {
    val userLD = MutableLiveData<User>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun register(list: List<User>) {
        launch {
            val db = buildDb(getApplication())
            db.userDao().insertAll(*list.toTypedArray())
        }
    }

    fun cekUsername(username: String) {
        launch {
            val db = buildDb(getApplication())
            userLD.postValue(db.userDao().cekUsername(username))
        }
    }

    fun login(username: String, password: String) {
        launch {
            val db = buildDb(getApplication())
            userLD.postValue(db.userDao().login(username, password))
        }
    }

    fun fetchUser(userId: Int) {
        // Fetch user data from database
        // Here you should implement fetching the user data from your data source (database, API, etc.)
        // Example:
        launch {
            val db = buildDb(getApplication())
            userLD.postValue(db.userDao().getUserDetail(userId))
        }
    }

    fun updateUser(username: String, email: String, password: String, id: Int) {
        launch {
            val db = buildDb(getApplication())
            db.userDao().update(username, email, password, id)
            // Optionally, refresh the user data
            userLD.postValue(db.userDao().getUserDetail(id))
        }
    }
}