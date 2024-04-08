package com.example.advuts160421001.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentHomeBinding
import com.example.advuts160421001.viewmodel.BeritaListViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: BeritaListViewModel
    private val beritaListAdapter  = BeritaListAdapter(arrayListOf())
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BeritaListViewModel::class.java)
        viewModel.refresh()
        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = beritaListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.beritaLivesData.observe(viewLifecycleOwner, Observer {
            beritaListAdapter.updateBeritaList(it)
        })
    }
}