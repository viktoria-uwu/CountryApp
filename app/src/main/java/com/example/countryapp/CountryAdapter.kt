package com.example.countryapp

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countryapp.databinding.ItemCountryBinding

class CountryAdapter(
    val onClick:(country: Country, position: Int) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private val list = ArrayList<Country>()

    fun setList(newList: List<Country>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
    inner class CountryViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(element: Country, position: Int) {
            binding.tvItem.text = element.name
            binding.dscrItem.text = element.description
            binding.btnItem.setOnClickListener{
                onClick(element, position)
            }

            Glide.with(binding.ivItem.context)
                .load(element.imageResId)
                .into(binding.ivItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val element = list[position]
        holder.bind(element, position)
    }
}