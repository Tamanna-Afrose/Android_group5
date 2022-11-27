package com.example.sports_mart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sports_mart.databinding.ActivitySoprtsBinding

class SoprtsActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySoprtsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySoprtsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cricket.setOnClickListener {
            val intent = Intent(this, CricketActivity::class.java)

            startActivity(intent)
        }
    }
}