package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val peso = intent.getStringExtra("KEY_PESO").toDouble()
        val altura = intent.getStringExtra("KEY_ALTURA").toDouble()

        val imc = peso / (altura * altura)
        txtResultado.text = "IMC: %.2f".format(imc)

        //Definindo lassificação
        if (imc < 18.5){
            txtCategoria.text = "Categoria: Abaixo do Peso"
        }else if (imc >= 18.6 && imc <= 24.9){
            txtCategoria.text = "Categoria: Peso Ideal"
        }else if (imc >= 25 && imc <= 29.9){
            txtCategoria.text = "Categoria: Levemente Acima do Peso"
        }else if(imc >= 30 && imc <= 34.9){
            txtCategoria.text= "Categoria: Obesidade grau 1"
        }else if (imc >= 35 && imc <= 39.9){
            txtCategoria.text = "Categoria: Obesidade Grau 2"
        }else{
            txtCategoria.text = "Categoria: Obesidade 3"
        }

        btnRefazer.setOnClickListener {
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}
