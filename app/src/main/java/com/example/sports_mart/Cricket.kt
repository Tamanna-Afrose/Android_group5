package com.example.sports_mart

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_mart.databinding.ActivityCricketBinding

class Cricket : AppCompatActivity() {
    private lateinit var binding: ActivityCricketBinding
    private var quantity: Int = 1
    private var productCost: Int = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCricketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.minusButton.setOnClickListener {
            quantity--
            if (quantity <= 0) {
                Log.d("Cricket", "quantity is less than 0")
                val toast = Toast.makeText(
                    applicationContext, "quantity can't be less than 1", Toast.LENGTH_SHORT
                )
                quantity = 1
            }
            binding.quantity.text = quantity.toString()
        }
        binding.plusButton.setOnClickListener {
            quantity++
            binding.quantity.text = quantity.toString()
        }
        binding.bill.setOnClickListener{
            if (binding.confirm.isChecked) {
                binding.cost.text = (quantity * productCost).toString()
            }
        }
    }
}