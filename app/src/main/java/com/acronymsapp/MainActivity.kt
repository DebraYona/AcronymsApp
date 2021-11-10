package com.acronymsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.acronymsapp.data.model.LFS
import com.acronymsapp.databinding.ActivityMainBinding
import com.acronymsapp.ui.adapters.AcronymsAdapter
import com.acronymsapp.ui.adapters.OnAbbreviationAdapterListener
import com.acronymsapp.ui.viewmodels.AcronymsViewModel

class MainActivity : AppCompatActivity(), OnAbbreviationAdapterListener {
    private lateinit var binding: ActivityMainBinding
    private var adapter: AcronymsAdapter? = null

    private val acronymsViewModel: AcronymsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listAcronyms.layoutManager = LinearLayoutManager(this)

        acronymsViewModel.onCreate("sr","sr")

        acronymsViewModel.acronyms.observe(this, Observer {
                response ->
            response?.let { setupRecyclerview(it) }

        })

    }

    private fun setupRecyclerview(list: List<LFS>) {
        adapter = AcronymsAdapter(list)
        binding.listAcronyms.adapter = adapter


    }


}