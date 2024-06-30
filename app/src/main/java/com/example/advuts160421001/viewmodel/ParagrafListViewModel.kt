package com.example.advuts160421001.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.model.Paragraf
import com.example.advuts160421001.model.ParagrafWithDataBeritaDanUser
import com.example.todoapp.util.buildDb
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ParagrafListViewModel(application: Application): AndroidViewModel(application), CoroutineScope{
    val paragrafLD = MutableLiveData<ArrayList<ParagrafWithDataBeritaDanUser>>()
    val paragrafLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

//    val TAG = "volleyTag"
//    private var queue: RequestQueue? = null

    fun fetch(beritaId: String) {
//        val urlOrigin = "http://10.0.2.2/anmp/uts/getParagrafbyIdBerita.php?beritaId=$beritaId"
//
//        queue = Volley.newRequestQueue( getApplication() )
//        val stringRequest = StringRequest(
//            Request.Method.GET, urlOrigin,
//            {
//                val sType = object : TypeToken<List<Paragraf>>() { }.type
//                val result = Gson().fromJson<List<Paragraf>>(it, sType)
//                paragrafLiveData.value = result as ArrayList<Paragraf>?
//                Log.d("showvoley", it)
//            },
//            {
//                Log.d("showvoleydetail", it.toString())
//            })
//
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)

        loadingLD.value = true
        paragrafLoadErrorLD.value = false

        launch {
            val db = buildDb(getApplication())
            paragrafLD.postValue(db.paragrafDao().selectParagrafByBeritaId(beritaId = beritaId.toInt()) as ArrayList<ParagrafWithDataBeritaDanUser>?)
            loadingLD.postValue(false)
        }
    }
}