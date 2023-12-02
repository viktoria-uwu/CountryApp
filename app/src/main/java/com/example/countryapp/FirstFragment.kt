package com.example.countryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.countryapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    lateinit var adapter: CountryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Country>()
        list.add(Country("Australia", "Golden beaches and mystic mountains in nature's embrace", "Description about Australia", R.drawable.australia))
        list.add(Country("France","Culinary finesse and art in harmony", "Description about France", R.drawable.france))
        list.add(Country("Italy", "Winemaking tradition and refined culinary art", "Description about Italy", R.drawable.italy))
        list.add(Country("Singapore", "Technological hub in the heart of Asia", "Description about Singapore", R.drawable.singapore))
        list.add(Country("Ukraine", "Rich cultural heritage and hospitality", "Description about Ukraine", R.drawable.ukraine))

        adapter = CountryAdapter() { country, position ->
            findNavController().navigate(FirstFragmentDirections.toSecondFragment(country.imageResId, country.name, country.info))
        }
        adapter.setList(list)
        binding.rv.adapter = adapter

    }
}