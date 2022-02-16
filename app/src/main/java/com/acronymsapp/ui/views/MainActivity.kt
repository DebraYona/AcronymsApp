package com.acronymsapp.ui.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.acronymsapp.data.model.LFS
import com.acronymsapp.databinding.ActivityMainBinding
import com.acronymsapp.ui.adapters.AcronymsAdapter
import com.acronymsapp.ui.adapters.OnAbbreviationAdapterListener
import com.acronymsapp.ui.viewmodels.AcronymsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnAbbreviationAdapterListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: AcronymsAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val acronymsViewModel: AcronymsViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.tvTotalAcronyms.isVisible = false
        binding.btnSearch.setOnClickListener(searchAcronyms)

        acronymsViewModel.acronyms.observe(this, Observer { response ->

            response?.let {
                binding.tvTotalAcronyms.isVisible = true
                binding.tvTotalAcronyms.text = it.size.toString() + " results"
                setupRecyclerview(it)
            }
        })
        acronymsViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private fun setupRecyclerview(list: List<LFS>) {
        Log.i("AcronymRecyclerView", list.toString())

        binding.listAcronyms.layoutManager = linearLayoutManager
        mAdapter = AcronymsAdapter(list)
        binding.listAcronyms.adapter = mAdapter
    }

    val searchAcronyms = View.OnClickListener {
        val acronym = binding.edAcronym.text.toString()
        if (acronym != "") {
            acronymsViewModel.onCreate(
                acronym,
                acronym
            )
        } else {
            Toast.makeText(this, "Enter Acronyms", Toast.LENGTH_SHORT).show()
        }

    }
}