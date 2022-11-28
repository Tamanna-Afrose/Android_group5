package com.example.sports_mart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_mart.databinding.ActivityCricketBinding
var quantity: Int = 1
var productCost: Int = 0
var totalCost: Int = 0
var shoppingBill=0
class CricketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCricketBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCricketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.golveText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialog_title)
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
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
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
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
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
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
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
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
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
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
            builder.setPositiveButton(R.string.addedItem) { dialogInterface, which ->
                Toast.makeText(applicationContext, "Item Added", Toast.LENGTH_LONG).show()
            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(applicationContext, R.string.cancelString, Toast.LENGTH_LONG).show()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        val textMarquee = binding.marqueeText
        textMarquee.isSelected = true
        textMarquee.isSingleLine = true
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
        binding.golves.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 460
        }
        binding.helmet.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 500
        }
        binding.ball.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 67
        }
        binding.stamp.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 1280
        }
        binding.jersey.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 290
        }
        binding.bat.setOnClickListener {
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 5300
        }
        binding.confirm.setOnClickListener {
            bill(productCost)
            binding.cost.text = "$quantity product \nCosts " + totalCost.toString()
            shoppingBill= shoppingBill+ totalCost
            quantity = 1;
            binding.quantity.text = quantity.toString()
        }
        binding.bill.setOnClickListener {
            Log.i("Cricket", "$shoppingBill")
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
    fun bill(productCost: Int) {
        Log.i("Cricket", "$quantity")
        totalCost = productCost * quantity
        Log.i("Cricket", "total amount $totalCost")
    }
}
