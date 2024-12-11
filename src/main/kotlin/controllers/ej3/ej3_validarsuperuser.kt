import java.util.Scanner

fun main() {
    val scanner = abrirScanner()
    val acceso = validarSuperusuari(scanner)
    mostrarResultado(acceso)

    cerrarScanner(scanner)
}

fun mostrarResultado(acceso : Boolean){
    if (acceso) {
        println("Acceso concedido")
    } else {
        println("Acceso denegado.")
    }
}

/**
 *
 *
 *
 *
 */
fun validarSuperusuari(scanner: Scanner): Boolean {
    // La contraseña correcta
    val passwordCorrecto = "Itbcontraseña"

    var intentos = 0
    var accesoPermitido = false  // Variable que indicará si el acceso es correcto

    while (intentos < 3 && !accesoPermitido) {  // Limite de 3 intentos
        val contra = pedirtexto("Introduce la contraseña: ", scanner)  // Pedimos la contraseña
        // Si la contraseña es correcta, permitimos el acceso
        if (contra == passwordCorrecto) {
            accesoPermitido = true
        } else {
            intentos++
            println("Password incorrecto. Te quedan ${3 - intentos} intentos.")
        }
    }
    return accesoPermitido
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
    val contra = scanner.nextLine()
    return contra
}
/**
 * Abrir Scanner
 * @author Bryan
 * @version 1.2
 * @since 11/12/2024
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
 * @since 11/12/2024
 * @param scanner cerramos el scanner
 */

fun cerrarScanner(scanner: Scanner){
    scanner.close()
}