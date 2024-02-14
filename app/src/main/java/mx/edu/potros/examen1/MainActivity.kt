package mx.edu.potros.examen1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    fun calcularFahrenheit(celsius:Double):Double{
        return (celsius * (1.8)) + 32
    }
    fun calcularCelsius(fahrenheit:Double):Double{
        return (fahrenheit - 32) / 1.8
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gCelsius:EditText=findViewById(R.id.etC)
        val gFahrenheit:EditText=findViewById(R.id.etF)
        val calcularGC:Button=findViewById(R.id.btnGC)
        val calcularGF:Button=findViewById(R.id.btnGF)

        calcularGC.setOnClickListener {
            var gradosF=0.0

            try{
                gradosF=gCelsius.text.toString().toDouble()
            } catch (e:java.lang.Exception) {
                gCelsius.setText("Ingrese valores reales.")
                print(e)
            }

            var resultado = calcularCelsius(gradosF)
            val formattedNumber = "%.2f".format(resultado)
            gCelsius.setText(formattedNumber)
        }

        calcularGF.setOnClickListener {
            var gradosC=0.0

            try{
                gradosC=gFahrenheit.text.toString().toDouble()
            } catch (e:java.lang.Exception) {
                gFahrenheit.setText("Ingrese valores reales.")
                print(e)
            }

            var resultado = calcularFahrenheit(gradosC)
            val formattedNumber = "%.2f".format(resultado)
            gFahrenheit.setText(formattedNumber)
        }
    }
}