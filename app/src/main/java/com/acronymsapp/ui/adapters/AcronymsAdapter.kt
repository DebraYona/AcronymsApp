package com.acronymsapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acronymsapp.R
import com.acronymsapp.data.model.LFS
import com.acronymsapp.databinding.ItemAcronymListBinding

class AcronymsAdapter(private val list: List<LFS>) :
    RecyclerView.Adapter<AcronymsAdapter.ViewHolder>() {

    private val TAG = AcronymsAdapter::class.java.name


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(layoutInflater.inflate(R.layout.item_acronym_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAcronymListBinding.bind(view)

        fun bind(acronyms: LFS) {
            binding.tvAbbreviation.text = acronyms.abbreviation
            binding.tvSince.text = acronyms.since.toString()
        }
    }

    private fun getItem(position: Int): LFS {
        return list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }


}