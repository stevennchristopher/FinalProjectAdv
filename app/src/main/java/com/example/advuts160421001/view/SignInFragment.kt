package com.example.advuts160421001.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.advuts160421001.databinding.FragmentSignInBinding
import com.example.advuts160421001.model.CekUser
import com.google.gson.Gson

class SignInFragment : Fragment() {
    private lateinit var binding:FragmentSignInBinding

    companion object {
        val activeIdUser = "random_16071239872_user"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSignUp.setOnClickListener {
            val action = SignInFragmentDirections.actionSignUpDirections()
            Navigation.findNavController(it).navigate(action)
        }

        binding.btnSign.setOnClickListener {
            if (binding.txtInputUsername.text.toString().trim().isEmpty()){
                binding.txtInputUsername.error = "Username cannot be empty"
            }
            else if(binding.txtInputPassword.text.toString().trim().isEmpty()){
                binding.txtInputPassword.error = "Password cannot be empty"
            }
            else{
                val username = binding.txtInputUsername.text.toString()
                val password = binding.txtInputPassword.text.toString()

                val q = Volley.newRequestQueue(requireContext())
                val url = "http://10.0.2.2/anmp/uts/signin.php"

                var stringRequest = object : StringRequest(
                    Request.Method.POST, url,
                    {
                        val cekUser = Gson().fromJson(it, CekUser::class.java)
                        Log.d("apiresult", cekUser.toString())

                        if (cekUser.result.toString() == "error")
                        {
                            Toast.makeText(requireContext(), "Invalid Username / Password", Toast.LENGTH_LONG).show()
                        }
                        else if(cekUser.result.toString() == "success")
                        {
                            val intent = Intent(requireContext(), HomeMainActivity::class.java)
                            intent.putExtra(HomeMainActivity.activeIdUser, cekUser.id.toString())
                            startActivity(intent)
                            requireActivity().finish()
                        }
                    },
                    Response.ErrorListener {
                        Log.e("apiresult", it.message.toString())
                    })
                {
                    override fun getParams(): MutableMap<String, String>{
                        val params = HashMap<String, String>()
                        params["username"] = username
                        params["password"] = password

                        return params
                    }
                }
                q.add(stringRequest)
            }
        }
    }
}