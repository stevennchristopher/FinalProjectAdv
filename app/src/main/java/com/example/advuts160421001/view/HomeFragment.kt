package com.example.advuts160421001.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advuts160421001.R
import com.example.advuts160421001.databinding.FragmentHomeBinding
import com.example.advuts160421001.viewmodel.BeritaListViewModel

class HomeFragment : Fragment() {
    private lateinit var viewModel: BeritaListViewModel
    private val beritaListAdapter  = BeritaListAdapter(arrayListOf())
    private lateinit var databinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home, container, false)
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BeritaListViewModel::class.java)
        viewModel.refresh()
        databinding.recView.layoutManager = LinearLayoutManager(context)
        databinding.recView.adapter = beritaListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.beritaLD.observe(viewLifecycleOwner, Observer {
            beritaListAdapter.updateBeritaList(it)
        })
    }
}