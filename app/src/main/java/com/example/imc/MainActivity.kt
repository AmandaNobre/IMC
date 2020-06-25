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

        //Configurando a seekBar peso
        val pesoSeekBar: SeekBar
        pesoSeekBar = findViewById(R.id.seekBarPeso)
        pesoSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtPeso.text = "Peso: " + progress + "KG"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        //Configurando a seekBar altura
        val alturaSeekBar: SeekBar
        alturaSeekBar = findViewById(R.id.seekBarAltura)
        alturaSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txtAltura.text = "Altura: " + progress + "m"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
        btnCalcular.setOnClickListener {
            val mIntent = Intent(this, ResultadoActivity::class.java)
            mIntent.putExtra("KEY_PESO", pesoSeekBar.progress.toString())
            mIntent.putExtra("KEY_ALTURA", alturaSeekBar.progress.toString())
            startActivity(mIntent)
            finish()
        }
    }
}
