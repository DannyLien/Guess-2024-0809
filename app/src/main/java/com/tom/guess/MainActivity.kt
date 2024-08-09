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
        var message = getString(R.string.yes_you_got_it)
        if (diff < 0) {
            message = getString(R.string.bigger)

        } else if (diff > 0) {
            message = getString(R.string.smaller)

        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok), null)
            .show()

    }

}//AppCompatActivity






