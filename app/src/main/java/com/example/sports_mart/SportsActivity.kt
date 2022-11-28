package com.example.sports_mart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sports_mart.databinding.ActivitySportsBinding

class SportsActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySportsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cricket.setOnClickListener {
            val intent = Intent(this, CricketActivity::class.java)
            startActivity(intent)
        }
        binding.football.setOnClickListener {
            val intent = Intent(this, FootballActivity::class.java)
            startActivity(intent)
        }
    }
}