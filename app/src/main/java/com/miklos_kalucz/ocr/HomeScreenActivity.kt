package com.miklos_kalucz.ocr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.miklos_kalucz.ocr.databinding.ActivityHomescreenBinding
import com.miklos_kalucz.ocr.databinding.ActivityMainBinding

class HomeScreenActivity : AppCompatActivity(){

    private lateinit var binding: ActivityHomescreenBinding
    private lateinit var buttonPrices: Button
    private lateinit var buttonBanknotes: Button
    private lateinit var buttonSettings: Button
    private lateinit var buttonInstructions: Button
    private lateinit var session: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {

        session = SharedPreferences(this)

        val newTheme = session.getTheme()


        Toast.makeText(this, newTheme, Toast.LENGTH_SHORT).show()

        if(newTheme == "HighContrastTheme") {
            theme.applyStyle(R.style.HighContrastTheme_OCR, true)

        }else{
            theme.applyStyle(R.style.Theme_OCR, true)
        }
        super.onCreate(savedInstanceState)


        binding = ActivityHomescreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonPrices = binding.btnPrices
        buttonBanknotes = binding.btnBanknotes
        buttonSettings = binding.btnSettings
        buttonInstructions = binding.btnInstruc

        buttonPrices.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        /*buttonBanknotes.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/
        buttonSettings.setOnClickListener{
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        /*buttonInstructions.setOnClickListener{
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }*/


        }

    }

