package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        val name = arguments?.getString("name")
        val description = arguments?.getString("description")

        root.findViewById<TextView>(R.id.textName).text = name
        root.findViewById<TextView>(R.id.textDescription).text = description

        return root
    }
}
