package com.tom.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tom.guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG: String? = MainActivity::class.java.name
    private lateinit var binding: ActivityMainBinding
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


    }//onCreate


    fun check(view: View) {
        val n = binding.number.text.toString().toInt()
        Log.d(TAG, "number : ${n}")

        val diff = secretNumber.validate(n)
        var message = "Yes, you got it"
        if (diff < 0) {
            message = "Bigger"

        } else if (diff > 0) {
            message = "Smaller"

        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle("Message")
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show()

    }

}//AppCompatActivity






