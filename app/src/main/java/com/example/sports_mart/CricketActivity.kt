package com.example.sports_mart

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_mart.databinding.ActivityCricketBinding

class CricketActivity : AppCompatActivity() {
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
                    applicationContext, R.string.quantityToast, Toast.LENGTH_SHORT
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
        binding.golveText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialog_title)
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding.helmetText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.helmetTitle)
            builder.setMessage(R.string.helmet_details)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding.batText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.batTitle)
            builder.setMessage(R.string.bat_details)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding.ballText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.ballTitle)
            builder.setMessage(R.string.bat_details)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding.stampText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.stampTitle)
            builder.setMessage(R.string.stamp_details)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        binding.jerseyText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.jerseyTitle)
            builder.setMessage(R.string.jersey_details)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem){dialogInterface, which ->
                Toast.makeText(applicationContext,"Item Added",Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,R.string.cancelString,Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        val textMarquee= binding.marqueeText
        textMarquee.isSelected=true
        textMarquee.isSingleLine=true

    }
}