package com.tom.guess

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.tom.guess.databinding.ActivityMaterialBinding

class MaterialActivity : AppCompatActivity() {
    private val TAG: String? = MaterialActivity::class.java.name
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMaterialBinding
    val secretNumber = SecretNumber()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        Log.d(TAG, "secret : ${secretNumber.secret}")
        binding.fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("Are yout sure?")
                .setPositiveButton(getString(R.string.ok), { dialog, which ->
                    secretNumber.reset()
                    binding.content.counter.setText(secretNumber.count.toString())
                    binding.content.number.setText("")
                })
                .setNeutralButton("Cancel", null)
                .show()
        }
        binding.content.counter.setText(secretNumber.count.toString())

    }

    fun check(view: View) {
        val n = binding.content.number.text.toString().toInt()
        Log.d(TAG, "number : ${n}")

        val diff = secretNumber.validate(n)
        var message = getString(R.string.yes_you_got_it)
        if (diff < 0) {
            message = getString(R.string.bigger)

        } else if (diff > 0) {
            message = getString(R.string.smaller)

        }
        binding.content.counter.setText(secretNumber.count.toString())
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok), null)
            .show()

    }

}