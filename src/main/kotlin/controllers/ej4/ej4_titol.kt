package controllers.ej4
import java.util.*

fun main(){
    val scanner = abrirScanner()
    val texto = pedirtexto("Introduce una frase: ", scanner)
    titol(texto)

    cerrarScanner(scanner)
}
/**
 * Pide una linea de texto al usuario
 * @author Bryan
 * @version 1.1
 * @since 11/12/2024
 * @param msg mensaje que muestra en pantalla
 * @param scanner funcion que permite introduccir texto al usuario
 * @return texto
 */
fun pedirtexto(msg: String, scanner: Scanner): String{
    print(msg)
    val texto = scanner.nextLine()
    return texto
}

/**
 * Centra la linea de texto que el usuario añadio anteriormente
 * @author Bryan
 * @version 1.0
 * @since 11/12/2024
 * @param texto utiliza el texto que añadio el usuario para centrarlo
 */
fun titol(texto: String) {
    // Amplio pantalla
    val ampliopantalla = 80

    // Longitud texto
    val longitudTexto = texto.length

    // calcula centrado
    val espais = (ampliopantalla - longitudTexto) / 2

    // Muestra el texto centrado
    println(" ".repeat(espais) + texto)
}

/**
 * Abrir Scanner
 * @author Bryan
 * @version 1.2
 * @since 10/12/2024
 *
 *
 * @param scanner abrimos el scanner
 * @return scanner
 */

fun abrirScanner(): Scanner{
    val scanner = Scanner(System.`in`)
    return scanner
}

/**
 * Cerrar Scanner
 * @author Bryan
 * @version 1.2
 * @since 10/12/2024
 *
 * @param scanner cerramos el scanner
 */

fun cerrarScanner(scanner: Scanner){
    scanner.close()
}