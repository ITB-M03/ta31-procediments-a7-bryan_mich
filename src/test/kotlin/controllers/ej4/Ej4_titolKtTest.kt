package controllers.ej4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Ej4_titolKtTest {

    @Test
    fun titol() {
    }

    @Test
    fun textoConLongitudExactaNoCambia() {
        val texto = "A".repeat(80)  // Un texto de exactamente 80 caracteres
        val resultado = capturarSalida(texto)

        assertEquals(texto, resultado, "El texto no debería modificarse si tiene exactamente 80 caracteres")
    }

    private fun capturarSalida(texto: String): Any? {
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        System.setOut(printStream)

        // Llamar a la función
        titol(texto)

        // Devolver la salida capturada
        return outputStream.toString().trim()


    }

    @Test
    fun textoConLongitudImparSeCentraCorrectamente() {
        val texto = "Texto impar"
        val resultado = capturarSalida(texto)
        val esperada = " ".repeat((80 - texto.length) / 2) + texto
        assertEquals(esperada, resultado, "El texto no se centra correctamente cuando tiene longitud impar")
    }


    @Test
    fun textoVacíoSeMuestraCorrectamente() {
        val texto = ""
        val resultado = capturarSalida(texto)

        assertEquals("", resultado, "El texto vacío no debería mostrar nada")
    }
}