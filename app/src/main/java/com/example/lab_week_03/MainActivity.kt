package com.example.lab_week_03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_week_03.ListFragment

class MainActivity : AppCompatActivity(), ListFragment.OnCoffeeSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .commit()
        }
    }

    override fun onCoffeeSelected(name: String, description: String) {
        val detailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putString("name", name)
                putString("description", description)
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}
