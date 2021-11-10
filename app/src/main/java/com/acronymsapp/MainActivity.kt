package com.acronymsapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.acronymsapp.data.model.LFS
import com.acronymsapp.databinding.ActivityMainBinding
import com.acronymsapp.ui.adapters.AcronymsAdapter
import com.acronymsapp.ui.adapters.OnAbbreviationAdapterListener
import com.acronymsapp.ui.viewmodels.AcronymsViewModel

class MainActivity : AppCompatActivity(), OnAbbreviationAdapterListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AcronymsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val acronymsViewModel: AcronymsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        linearLayoutManager = LinearLayoutManager(this)

        binding.btnSearch.setOnClickListener(searchAcronyms)


        acronymsViewModel.acronyms.observe(this, Observer {
                response ->
            response?.let { setupRecyclerview(it) }

        })
        acronymsViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

    }

    private fun setupRecyclerview(list: List<LFS>) {
        binding.listAcronyms.layoutManager = linearLayoutManager

        mAdapter = AcronymsAdapter(list)
        binding.listAcronyms.adapter = mAdapter


    }

    val searchAcronyms =  View.OnClickListener(){
        acronymsViewModel.onCreate(binding.edAcronym.text.toString(),binding.edAcronym.text.toString())

    }


}