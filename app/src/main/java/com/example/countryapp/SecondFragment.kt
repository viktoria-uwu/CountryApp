package com.example.countryapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SecondFragment : Fragment() {

    val args: SecondFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val img = view.findViewById<ImageView>(R.id.imgInfo)
        val tvT = view.findViewById<TextView>(R.id.tvTitle)
        val tvI = view.findViewById<TextView>(R.id.tvInfo)


        val imgI = args.image
        val title = args.name
        val info = args.info

        img.setImageResource(imgI)
        tvT.text = title
        tvI.text = info


        val button = view.findViewById<Button>(R.id.btnToFirst)
        button.setOnClickListener{ findNavController().navigate(R.id.toFirstFragment)
        }

    }


}