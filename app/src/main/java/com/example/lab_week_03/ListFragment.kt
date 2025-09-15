package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    interface OnCoffeeSelectedListener {
        fun onCoffeeSelected(name: String, description: String)
    }

    private lateinit var listener: OnCoffeeSelectedListener

    private val coffees = listOf(
        "AFFOGATO" to "Espresso poured on a vanilla ice cream. Served in a cappuccino cup.",
        "AMERICANO" to "Espresso with added hot water.",
        "CAFE LATTE" to "Espresso with steamed milk and a small amount of milk foam."
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnCoffeeSelectedListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnCoffeeSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        val listView = root.findViewById<ListView>(R.id.listView)
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            coffees.map { it.first }
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val coffee = coffees[position]
            listener.onCoffeeSelected(coffee.first, coffee.second)
        }

        return root
    }
}
