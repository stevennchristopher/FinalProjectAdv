package com.example.advuts160421001.view

import android.view.View
import android.widget.CompoundButton
import com.example.advuts160421001.model.Berita
import com.example.advuts160421001.model.User
import java.util.Objects

interface ReadButtonClick {
    fun onReadButtonClick(v: View)
}
interface UpdateButtonClick {
    fun onUpdateButtonClick(v: View, obj:User)
}

interface SignButtonClick {
    fun onSignInButtonClick(v: View)
    fun toSignUpButtonClick(v: View)
}

interface SignUpButtonClick {
    fun onRegisterButtonClick(v: View)
    fun toSignInButtonClick(v: View)
}

interface ArrowButtonClick {
    fun onPrevButtonClick(v: View)
    fun onNextButtonClick(v: View)
}