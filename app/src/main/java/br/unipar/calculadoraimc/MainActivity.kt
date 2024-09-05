package br.unipar.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edAltura = findViewById<EditText>(R.id.edAltura)
        val edPeso = findViewById<EditText>(R.id.edPeso)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val labelResultado = findViewById<TextView>(R.id.labelResultado)

        btnCalcular.setOnClickListener{
            val altura = edAltura.text.toString()
            val peso = edPeso.text.toString()

            if (altura.isNotEmpty() and peso.isNotEmpty()) {
                val IMC = peso.toFloat() / (altura.toFloat() * altura.toFloat())
                var mensagem = "IMC: $IMC "
                if (IMC>=30) {
                    mensagem += "\nCategoria: Obesidade"
                } else if (IMC>=25) {
                    mensagem += "\nCategoria: Sobrepeso"
                } else if (IMC>=18.5) {
                    mensagem += "\nCategoria: Peso Normal"
                } else {
                    mensagem += "\nCategoria: Abaixo do Peso"
                }
                labelResultado.text = mensagem
            } else {
                labelResultado.text = "Insira valores válidos"
            }
        }
    }
}