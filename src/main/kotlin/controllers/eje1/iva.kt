package controllers.eje1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

var sc = abrirScanner()
fun main() {

    var precio = Ingresepreu("ingrese numero: ")
    var fecha = ingresarFecha("ingrese Fecha")
    var resultado = calcularIva(precio, fecha)
    println(resultado)



}

fun calcularIva(preu: Double, fecha: LocalDate): Double {
    var resultado: Double = 0.0
    val fechaInicio: LocalDate = LocalDate.of(1986, 1, 1)
    val fechaFin: LocalDate = LocalDate.of(1992, 12, 31)
    if (fecha in fechaInicio..fechaFin) {
        resultado = (preu * 0.12)
    }
    return resultado

}

fun abrirScanner(): Scanner {
    val scanner = Scanner(System.`in`)
    return scanner
}

fun ingresarFecha(msg: String): LocalDate {
    println(msg)
    sc.nextLine()
    var data: LocalDate
    val formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy")// esta 3 lineas se correspnden a la introduccion de fecha a travez de un string
    val dataString = sc.nextLine()
    data = LocalDate.parse(dataString, formatter)
    return data

}

//funcion para ingresar un numero de tipo decimal
fun Ingresepreu(msg: String): Double {
    println(msg)
    var resultado = sc.nextDouble()
    return resultado
}

enum class Tipoiva(val iva:String,val porcentaje:Int){
}
