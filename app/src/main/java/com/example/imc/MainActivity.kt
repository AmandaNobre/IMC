package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var alturaDecimal = 0.0
        var pesoDecimal = 0.0

        //Configurando a seekBar peso
        val pesoSeekBar: SeekBar
        pesoSeekBar = findViewById(R.id.seekBarPeso)
        pesoSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                pesoDecimal = progress/10.toDouble()
                txtPesoDecimal.text = pesoDecimal.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //Configurando a seekBar altura
        val alturaSeekBar: SeekBar
        alturaSeekBar = findViewById(R.id.seekBarAltura)
        alturaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                alturaDecimal = progress/100.toDouble()
                txtAlturaDecimal.text = alturaDecimal.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        btnCalcular.setOnClickListener {
            if (txtPesoDecimal.text == "0.0" || txtAlturaDecimal.text == "0.0"){
                Toast.makeText(applicationContext, "Apresente sua altura e peso", Toast.LENGTH_LONG).show()
            }else{
                val mIntent = Intent(this, ResultadoActivity::class.java)
                mIntent.putExtra("KEY_PESO", txtPesoDecimal.text)
                mIntent.putExtra("KEY_ALTURA", txtAlturaDecimal.text)
                startActivity(mIntent)
                finish()
            }


        }
    }
}
