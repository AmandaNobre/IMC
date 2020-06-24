package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent.getStringExtra("KEY_PESO").toInt()
        val altura = intent.getStringExtra("KEY_ALTURA").toInt()

        val imc = peso / (altura * altura)
        txtResultado.text = imc.toString()

        //Definindo lassificação 
        if (imc < 18.5){
            txtCategoria.text = "Abaixo do Peso"
        }else if (imc >= 18 && imc <= 24){
            txtCategoria.text = "Peso Ideal"
        }else if (imc >= 25 && imc <= 29){
            txtCategoria.text = "Levemente Acima do Peso"
        }else if(imc >= 30 && imc <= 34){
            txtCategoria.text= "Obesidade grau 1"
        }else if (imc >= 35 && imc <= 39){
            txtCategoria.text = "Obesidade Grau 2"
        }else{
            txtCategoria.text = "Obesidade 3"
        }

        btnRefazer.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}
