package com.example.advuts160421001.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.model.Berita
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BeritaListViewModel(application: Application): AndroidViewModel(application){
    val beritaLivesData = MutableLiveData<ArrayList<Berita>>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        queue = Volley.newRequestQueue( getApplication() )

        val url = "http://10.0.2.2/anmp/uts/getBerita.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Berita>>() { }.type
                val result = Gson().fromJson<List<Berita>>(it, sType)
                beritaLivesData.value = result as ArrayList<Berita>?
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}