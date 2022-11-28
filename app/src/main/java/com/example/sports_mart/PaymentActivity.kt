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
            val email= binding.email.text
            if(email == null)
            {
                val toast = Toast.makeText(
                    applicationContext, R.string.mailToast, Toast.LENGTH_SHORT
                )
                toast.show()
            }
            val address= binding.address.text
            if(address == null)
            {
                val toast = Toast.makeText(
                    applicationContext, R.string.addressToast, Toast.LENGTH_SHORT
                )
                toast.show()
            }
            if(email!=null && address!=null)
            {
                val toast = Toast.makeText(
                    applicationContext, R.string.confirmOrder, Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }
        binding.backButotn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }
    }
}

