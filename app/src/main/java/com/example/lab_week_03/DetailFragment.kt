package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
// import android.widget.ImageView // Uncomment if you add an ImageView and drawable images
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs // Required for Safe Args

class DetailFragment : Fragment() {

    // Using Safe Args to retrieve the argument passed from ListFragment
    // This assumes your argument in nav_graph.xml for this fragment is named "itemText"
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        // Find the views in fragment_detail.xml
        val textViewCoffeeName = view.findViewById<TextView>(R.id.textViewCoffeeName)
        val textViewCoffeeDescription = view.findViewById<TextView>(R.id.textViewCoffeeDescription)
        // val imageViewCoffee = view.findViewById<ImageView>(R.id.imageViewCoffee) // Uncomment if using
        val buttonBack = view.findViewById<Button>(R.id.buttonBack)

        // Get the coffee name that was passed from ListFragment
        val coffeeName = args.itemText // "itemText" is the name of the argument in your nav_graph

        // Set the coffee name in the dedicated TextView
        textViewCoffeeName.text = coffeeName

        // --- Populate details based on the coffeeName ---
        // You would typically get this data from a ViewModel, a database, or a repository in a real app.
        // For this example, we'll use a simple 'when' statement.

        var description = "No details available for this coffee."
        // var imageResId: Int? = null // Uncomment if using ImageView

        when (coffeeName) {
            "Affogato" -> {
                description = "An Affogato is a classic Italian coffee-based dessert. It consists of a scoop of vanilla gelato or ice cream 'drowned' with a shot of hot espresso. Simple, yet incredibly satisfying."
                // imageResId = R.drawable.ic_affogato // Example: if you have an affogato image
            }
            "Latte" -> {
                description = "A Caffè Latte is a coffee drink made with espresso and steamed milk. It is typically topped with a thin layer of foam. Variations include adding flavored syrups."
                // imageResId = R.drawable.ic_latte // Example
            }
            "Espresso" -> {
                description = "Espresso is a concentrated coffee beverage brewed by forcing a small amount of nearly boiling water under pressure through finely-ground coffee beans. It's the base for many other coffee drinks."
                // imageResId = R.drawable.ic_espresso // Example
            }
            "Cappuccino" -> {
                description = "A Cappuccino is an espresso-based coffee drink that originated in Italy, prepared with steamed milk foam. It is traditionally composed of a single espresso shot and equal parts steamed milk and milk microfoam."
                // imageResId = R.drawable.ic_cappuccino // Example
            }
            "Mocha" -> {
                description = "A Caffè Mocha, also called mochaccino, is a chocolate-flavored variant of a caffè latte. It typically consists of espresso, hot milk, and chocolate, often in the form of cocoa powder or chocolate syrup, and may include whipped cream."
                // imageResId = R.drawable.ic_mocha // Example
            }
        }

        textViewCoffeeDescription.text = description

        buttonBack.setOnClickListener {
            findNavController().popBackStack() // Navigates to the previous screen in the back stack
        }

        return view
    }
}
