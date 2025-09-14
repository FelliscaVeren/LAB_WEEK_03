package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private val coffeeList = listOf(
        "AFFOGATO" to "Espresso poured on a vanilla ice cream. Served in a cappuccino cup.",
        "AMERICANO" to "Espresso with added hot water. Served in a regular coffee cup.",
        "CAFFE LATTE" to "Espresso with steamed milk and foam. Served in a tall glass."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView = view.findViewById<ListView>(R.id.coffee_list_view)
        val titles = coffeeList.map { it.first }

        listView.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            titles
        )

        listView.setOnItemClickListener { _, _, position, _ ->
            val (title, desc) = coffeeList[position]

            val detailFragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putString("title", title)
                    putString("desc", desc)
                }
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
