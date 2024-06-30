package com.example.advuts160421001.view

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentBeritaDetailBinding
import com.example.advuts160421001.databinding.FragmentProfileBinding
import com.example.advuts160421001.model.Paragraf
import com.example.advuts160421001.viewmodel.ParagrafListViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.util.concurrent.TimeUnit

class BeritaDetailFragment : Fragment() {
    private lateinit var viewModel:ParagrafListViewModel
    private lateinit var databinding: FragmentBeritaDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil.inflate<FragmentBeritaDetailBinding>(inflater, R.layout.fragment_berita_detail, container, false)
        //databinding.listener = this
        // Inflate the layout for this fragment
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val beritaId = BeritaDetailFragmentArgs.fromBundle(requireArguments()).beritaId

        viewModel = ViewModelProvider(this).get(ParagrafListViewModel::class.java)
        viewModel.fetch(beritaId)

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.paragrafLD.observe(viewLifecycleOwner, Observer {
            databinding.paragraf = it[0]

                Picasso.get().load(it[0].urlFotoBerita)
                    .into(databinding.imgParagraf, object : Callback {
                        override fun onSuccess() {
                            databinding.imgParagraf.visibility = View.VISIBLE
                        }

                        override fun onError(e: Exception?) {
                            Log.e("picasso_error", e.toString())
                        }
                    })
        })

//        viewModel.paragrafLiveData.observe(viewLifecycleOwner, Observer { paragrafList ->
//            var counter = 0
//
//            val picasso = Picasso.Builder(requireContext())
//            picasso.build().load(paragrafList[counter].urlFotoBerita).into(binding.imgParagraf)
//            binding.txtTitleBeritaInParagraf.text = paragrafList[counter].judulBerita
//            binding.txtUsernameParagraf.text = "@" + paragrafList[counter].username_pembuat
//
//            binding.txtSubJudulParagraf.text = paragrafList[counter].subjudul
//            binding.txtDeskripsiParagraf.text = paragrafList[counter].deskripsi
//
//            binding.btnNext.setOnClickListener {
//                if (counter < paragrafList.size - 1) {
//                    counter += 1
//
//                    binding.txtSubJudulParagraf.text = paragrafList[counter].subjudul
//                    binding.txtDeskripsiParagraf.text = paragrafList[counter].deskripsi
//
//                    if(counter+1 > paragrafList.size - 1){
//                        val color = ContextCompat.getColor(requireContext(), R.color.md_theme_dark_outline)
//                        binding.btnNext.backgroundTintList = ColorStateList.valueOf(color)
//                    }
//
//                    if(counter > 0){
//                        val color = ContextCompat.getColor(requireContext(), R.color.md_theme_dark_inversePrimary)
//                        binding.btnPrevious.backgroundTintList = ColorStateList.valueOf(color)
//                    }
//
//                }
//            }
//
//            binding.btnPrevious.setOnClickListener {
//                if (counter > 0) {
//                    counter -= 1
//
//                    Log.d("counternow", counter.toString())
//
//                    binding.txtSubJudulParagraf.text = paragrafList[counter].subjudul
//                    binding.txtDeskripsiParagraf.text = paragrafList[counter].deskripsi
//
//                    if(counter < paragrafList.size - 1){
//                        val color = ContextCompat.getColor(requireContext(), R.color.md_theme_dark_inversePrimary)
//                        binding.btnNext.backgroundTintList = ColorStateList.valueOf(color)
//                    }
//
//                    if(counter == 0){
//                        val color = ContextCompat.getColor(requireContext(), R.color.md_theme_dark_outline)
//                        binding.btnPrevious.backgroundTintList = ColorStateList.valueOf(color)
//                    }
//
//                }
//            }
//        })


    }
}