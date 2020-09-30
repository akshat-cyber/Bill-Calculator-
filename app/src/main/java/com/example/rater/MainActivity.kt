package com.example.rater
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rater.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.buttonCalCulate.setOnClickListener {
           val num  = clicked().toString()
           binding.tipResult.text = num
           Toast.makeText(this, "Your bill = $num", Toast.LENGTH_SHORT).show()
       }
    }
    fun clicked() : Double {
        val costService = when (binding.costOfService.text){
            binding.costOfService.text  -> binding.costOfService.text
            null -> 0
            else -> 0
        }.toString().toDouble()
        var tipOptions  : Double = when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_thirty_percent -> 0.3
             R.id.option_thirty_percent -> 0.4
             else -> 0.0
        }
        return costService * tipOptions
    }
}