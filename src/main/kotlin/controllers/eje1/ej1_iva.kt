package controllers.eje1

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

enum class TipoIva(
    val general: Double,
    val reducido: Double,
    val superReducido: Double?,
    val exento: Double,
    val empiezaVigencia: LocalDate
) {
    VIGENCIA_1986(12.0, 6.0, null, 0.0, LocalDate.of(1986, 1, 1)),
    VIGENCIA_1992(15.0, 6.0, null, 0.0, LocalDate.of(1992, 1, 1)),
    VIGENCIA_1993(15.0, 6.0, 3.0, 0.0, LocalDate.of(1993, 1, 1)),
    VIGENCIA_1995(16.0, 7.0, 4.0, 0.0, LocalDate.of(1995, 1, 1)),
    VIGENCIA_2010(18.0, 8.0, 4.0, 0.0, LocalDate.of(2010, 1, 1)),
    VIGENCIA_2012(21.0, 10.0, 4.0, 0.0, LocalDate.of(2012, 7, 15)),
    VIGENCIA_2025(32.0, 21.0, 10.0, 0.0, LocalDate.of(2025, 1, 1));

    /**
     * //forma que tiene kotlin de representar un método estático(que no necesita instanciar la clase)
     *  Función para obtener la vigencia correspondiente a una fecha
     *  @author Mich
     *  @return  devuelve el último elemento que cumple esa condición (tipo TipoIva).
     *  @throws IllegalArgumentException si se solicita una fecha que está fuera de rango se lanza una excepción
     */
    companion object {
        fun obtenerVigencia(data: LocalDate): TipoIva {
            return values().lastOrNull { it.empiezaVigencia <= data }
                ?: throw IllegalArgumentException("Data de compra fora del rang de vigències disponibles")
        }
    }

}


fun main() {
    //var sc = abrirScanner()
    var precio = Ingresepreu("ingrese Precio: ")
    var fecha = ingresarFecha("ingrese Fecha en formato dd/MM/yyyy: ")
    var tipoIva = ingresarTipoIva("Ingrese tipo de Iva (GENERAL, REDUIT, SUPERREDUIT, EXEMPT): ")
    val resultado = calcularIVA(precio, tipoIva, fecha)
    println("El precio final con IVA aplicado es: %.2f€".format(resultado))
}

/**
 * Función para ingresar valor a tratar
 * @author Mich
 * @return retorna el número que ingresa por teclado
 */

fun Ingresepreu(msg: String): Double {
    println(msg)
    var sc = abrirScanner()
    var resultado = sc.nextDouble()
    return resultado
}

/**
 * Funcion para ingresar fecha
 * @return solicita al usuario que introduzca una fecha en el formato dd/MM/yyyy.
 * @author Mich
 */
fun ingresarFecha(msg: String): LocalDate {
    var sc = abrirScanner()
    println(msg)
    var data: LocalDate
    val formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dataString = sc.nextLine()
    data = LocalDate.parse(dataString, formatter)
    return data

}

/**
 * Función para ingresar que tipo de Iva vamos a solicitar
 * @author Mich
 * no devuelve nada
 */

fun ingresarTipoIva(msg: String): String {
    println(msg)
    var sc = abrirScanner()
    return sc.nextLine().uppercase()
}

/**
 * Funcion para Calcular el Iva
 * @author Mich
 * @return devuelve el valor ingresado más el tipo de IVA
 */
fun calcularIVA(precio: Double, tipoIva: String, fecha: LocalDate): Double {
    val vigencia = TipoIva.obtenerVigencia(fecha)
    val porcentaje = when (tipoIva) {
        "GENERAL" -> vigencia.general
        "REDUCIDO" -> vigencia.reducido
        "SUPERREDUCIDO" -> vigencia.superReducido ?: 0.0
        "EXENTO" -> vigencia.exento
        else -> throw IllegalArgumentException("Tipo de IVA no válido")
    }
    return precio * (1 + porcentaje / 100)
}

/**
 * Funcion para Abrir Scanner
 */
fun abrirScanner(): Scanner {
    val scanner = Scanner(System.`in`)
    return scanner
}

