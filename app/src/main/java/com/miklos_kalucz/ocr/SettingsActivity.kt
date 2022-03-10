package com.miklos_kalucz.ocr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import com.miklos_kalucz.ocr.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var session: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        session = SharedPreferences(this)
        val newTheme = session.getTheme()

        if(newTheme == "HighContrastTheme") {
            theme.applyStyle(R.style.HighContrastTheme_OCR, true)
        }else{
            theme.applyStyle(R.style.Theme_OCR, true)
        }

        val switchState = session.getSwitchState()



        super.onCreate(savedInstanceState)


        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val highContrast : Switch = binding.contrastSwitch

        if(switchState){
            highContrast.setChecked(true)
        }else{
            highContrast.setChecked(false)
        }


        highContrast.setOnCheckedChangeListener{ _, isChecked ->
            if(isChecked){
                session.changeTheme("HighContrastTheme")
                theme.applyStyle(R.style.HighContrastTheme_OCR, true)
                Toast.makeText(this, "HighContrastTheme", Toast.LENGTH_SHORT).show()
                session.setSwitchState(true)
            }
            else{
                session.changeTheme("Theme")
                theme.applyStyle(R.style.Theme_OCR, true)
                Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show()
                session.setSwitchState(false)
            }

        }
    }
}