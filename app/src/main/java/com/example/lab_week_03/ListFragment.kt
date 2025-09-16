package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val coffeeList = listOf("Affogato", "Latte", "Espresso", "Cappuccino", "Mocha")
        val listView = view.findViewById<ListView>(R.id.listView)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coffeeList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val name = coffeeList[position]
            val action = ListFragmentDirections.coffeeIdAction(name)
            findNavController().navigate(action)
        }

        return view
    }
}
