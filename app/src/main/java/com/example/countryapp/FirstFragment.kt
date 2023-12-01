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
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = ArrayList<Country>()
        list.add(Country("Australia", "", R.drawable.Australia))
        list.add(Country("France","", R.drawable.France))
        list.add(Country("Italy", "", R.drawable.Italy))
        list.add(Country("Singapore", "", R.drawable.Singapore))
        list.add(Country("Ukraine", "", R.drawable.Ukraine))

        adapter = CountryAdapter()
        adapter.setList(list)
        binding.rv.adapter = adapter

        binding.btnToSecond.setOnClickListener{
            findNavController().navigate(FirstFragmentDirections.toSecondFragment("some dkfdskfjgdf"))
        }
    }
}