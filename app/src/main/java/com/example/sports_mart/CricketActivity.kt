package com.example.sports_mart

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sports_mart.databinding.ActivityCricketBinding

var quantity: Int = 0
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
            showAlertDialog(R.string.dialog_title,R.string.dialogMessage )
        }
        binding.helmetText.setOnClickListener {
            showAlertDialog(R.string.helmetTitle,R.string.helmet_details)
        }
        binding.batText.setOnClickListener {
            showAlertDialog(R.string.batTitle, R.string.bat_details)
        }
        binding.ballText.setOnClickListener {
            showAlertDialog(R.string.ballTitle,R.string.bat_details)
        }
        binding.stampText.setOnClickListener {
            showAlertDialog(R.string.stampTitle,R.string.stamp_details)
        }
        binding.jerseyText.setOnClickListener {
            showAlertDialog(R.string.jerseyTitle,R.string.jersey_details)
        }
        val textMarquee = binding.marqueeText
        textMarquee.isSelected = true
        textMarquee.isSingleLine = true
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
        binding.golves.setOnClickListener {
            animationImage(binding.golves)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 460
        }
        binding.helmet.setOnClickListener {
            animationImage(binding.helmet)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 500
        }
        binding.ball.setOnClickListener {
            animationImage(binding.ball)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 67
        }
        binding.stamp.setOnClickListener {
            animationImage(binding.stamp)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 1280
        }
        binding.jersey.setOnClickListener {
            animationImage(binding.jersey)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 290
        }
        binding.bat.setOnClickListener {
            animationImage(binding.bat)
            Toast.makeText(applicationContext, R.string.itemSelectToast, Toast.LENGTH_LONG).show()
            productCost = 5300
        }
        binding.confirm.setOnClickListener {
            bill(productCost)
            binding.cost.text = "$quantity product \nCosts $totalCost"
            shoppingBill += totalCost
            quantity = 1
            binding.quantity.text = quantity.toString()
        }
        binding.bill.setOnClickListener {
            Log.i("Cricket", "$shoppingBill")
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showAlertDialog(title: Int, message: Int){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
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
    private fun animationImage(image:ImageView) {
        image.visibility = View.VISIBLE
        val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        image.startAnimation(animationFadeIn)
    }
    private fun bill(productCost: Int) {
        Log.i("Cricket", "$quantity")
        totalCost = productCost * quantity
        Log.i("Cricket", "total amount $totalCost")
    }
}
