package controllers.eje2

import java.util.*

fun main() {
    var scanner = abrirScanner()
    var numero = ingresarNumero("Ingrese un numero entre 1 y 3999: ", scanner)
    var convertir = roman(numero)

    println(convertir)
}

/**
 * Funcion para ingresar un numero que este comprendido entre 1 y
 */
fun ingresarNumero(msg: String, scanner: Scanner): Int {
    print(msg)
    val numero = scanner.nextInt()
    return numero
}

/**
 * Funcion para convertir un numero decimal a numero Romano
 * @author Mich
 * @return devuelve una conversion de numero decimal  a Romano
 */
fun roman(numero: Int): String {
    if (numero < 1 || numero > 3999) {

        println("El número debe estar entre 1 y 3999")
    }
    val valoresRomanos = listOf(
        1000 to "M", 900 to "CM", 500 to "D", 400 to "CD",
        100 to "C", 90 to "XC", 50 to "L", 40 to "XL",
        10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I"
    )
    var numeroActual = numero
    val resultado = StringBuilder()
    for ((valor, simbolo) in valoresRomanos) {
        while (numeroActual >= valor) {
            resultado.append(simbolo)
            numeroActual -= valor
        }
    }
    return resultado.toString()
}

fun abrirScanner(): Scanner {
    var scannner: Scanner = Scanner(System.`in`)
    return scannner
}