package com.example.sports_mart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_mart.databinding.ActivityFootballBinding

class FootballActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFootballBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFootballBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textMarquee = binding.marqueeText
        textMarquee.isSelected = true
        textMarquee.isSingleLine = true
        binding.footballText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.footballTittle)
            builder.setMessage(R.string.footballDetails)
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
        binding.netText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.netTitle)
            builder.setMessage(R.string.net_details)
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
        binding.shoesText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.shoe_title)
            builder.setMessage(R.string.shoe_details)
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
        binding.brazilJerseyText.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.brazilJerseyText)
            builder.setMessage(R.string.brazilJersey_detail)
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
        binding.minusButton.setOnClickListener {
            quantity--
            if (quantity <= 0) {
                Log.d("Cricket", "quantity is less than 0")
                val toast = Toast.makeText(
                    applicationContext, R.string.minusToast, Toast.LENGTH_SHORT
                )
                toast.show()
                quantity = 1
            }
            binding.quantity.text = quantity.toString()
        }
        binding.plusButton.setOnClickListener {
            quantity++
            binding.quantity.text = quantity.toString()
        }
        binding.football.setOnClickListener {
            animationImage(binding.football)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 840
        }
        binding.goalPost.setOnClickListener {
            animationImage(binding.goalPost)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 280
        }
        binding.shoes.setOnClickListener {
            animationImage(binding.shoes)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 1323
        }
        binding.brazilJersey.setOnClickListener {
            animationImage(binding.brazilJersey)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 227
        }
        binding.confirm.setOnClickListener {
            bill(productCost)
            binding.cost.text = "$quantity product \nCosts " + totalCost.toString()
            shoppingBill = shoppingBill + totalCost
            quantity = 1;
            binding.quantity.text = quantity.toString()
        }
        binding.bill.setOnClickListener {
            Log.i("Cricket", "$shoppingBill")
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
    private fun bill(productCost: Int) {
        Log.i("Cricket", "$quantity")
        totalCost = productCost * quantity
        Log.i("Cricket", "total amount $totalCost")
    }
    private fun animationImage(image: ImageView) {
        image.visibility = View.VISIBLE
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        image.startAnimation(animationFadeIn)
    }
}