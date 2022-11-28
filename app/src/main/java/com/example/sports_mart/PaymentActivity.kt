package com.example.sports_mart

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sports_mart.databinding.ActivityPaymentBinding
class PaymentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentBinding
    @SuppressLint("StringFormatMatches")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.paymentShow.text= getString(R.string.totalBill,shoppingBill )
        binding.orderButton.setOnClickListener {
            orderConfirm()
        }
        binding.backButotn.setOnClickListener {
            shoppingBill=0
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    @SuppressLint("StringFormatMatches")
    fun orderConfirm() {
        val email: String = binding.email.text.toString()
        if (email=="") {
            val toast = Toast.makeText(
                applicationContext, R.string.mailToast, Toast.LENGTH_SHORT
            )
            toast.show()
        }
        val address = binding.address.text.toString()
        if (address == "") {
            val toast = Toast.makeText(
                applicationContext, R.string.addressToast, Toast.LENGTH_SHORT
            )
            toast.show()
        }
        if (email != "" && address != "") {
            val toast = Toast.makeText(
                applicationContext, R.string.confirmOrder, Toast.LENGTH_LONG
            )
            toast.show()
            shoppingBill=0
            binding.paymentShow.text= getString(R.string.totalBill,shoppingBill)
        }
    }
}

