package com.example.advuts160421001.view

import android.view.View
import android.widget.CompoundButton
import com.example.advuts160421001.model.Berita

interface ReadButtonClick {
    fun onReadButtonClick(v: View)
}

interface SignButtonClick {
    fun onSignInButtonClick(v: View)
    fun toSignUpButtonClick(v: View)
}