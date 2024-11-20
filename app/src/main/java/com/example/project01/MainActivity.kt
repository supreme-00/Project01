package com.example.project01

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project01.databinding.ActivityMainBinding

data class EVProblem(val problem: String, val solution: String, val reference: String)

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EVProblemAdapter
    private val problemsList = mutableListOf(
        EVProblem(
            "Limited Driving Range",
            "Plan trips, use regenerative braking, maintain efficient driving habits.",
            "https://www.autoexplored.com/ev-problems"
        ),
        EVProblem(
            "Slow Charging Times",
            "Use fast chargers, install a Level 2 charger at home, maintain charging equipment.",
            "https://carsofelectric.com/ev-charging-tips"
        ),
        EVProblem(
            "Battery Degradation",
            "Avoid full charges and deep discharges, park in shade, perform regular checks.",
            "https://goodcar.com/ev-battery-care"
        ),
        EVProblem(
            "High Repair Costs",
            "Choose extended warranties, visit specialized repair centers, maintain regularly.",
            "https://www.autoexplored.com/ev-maintenance"
        ),
        EVProblem(
            "Lack of Charging Infrastructure",
            "Use apps to locate stations, advocate for more infrastructure, consider hybrids.",
            "https://carsofelectric.com/charging-infrastructure"
        ),
        EVProblem(
            "Cold Weather Performance",
            "Precondition battery, use eco-driving modes, insulate battery against cold.",
            "https://goodcar.com/ev-winter-tips"
        ),
        EVProblem(
            "Software Faults",
            "Perform updates, use diagnostic tools, consult service centers.",
            "https://www.autoexplored.com/software-faults"
        ),
        EVProblem(
            "Charging Equipment Failures",
            "Inspect cables and ports, reset charging systems, use alternate chargers.",
            "https://carsofelectric.com/charging-tips"
        ),
        EVProblem(
            "Limited Model Variety",
            "Research new models, explore customizations or add-ons.",
            "https://www.autoexplored.com/ev-variety"
        ),
        EVProblem(
            "High Initial Cost",
            "Leverage subsidies, explore pre-owned EVs, factor long-term savings.",
            "https://goodcar.com/ev-cost-tips"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        adapter = EVProblemAdapter(problemsList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Search bar functionality
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().lowercase()
                val filteredList = problemsList.filter {
                    it.problem.lowercase().contains(query)
                }
                adapter.updateList(filteredList)
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
