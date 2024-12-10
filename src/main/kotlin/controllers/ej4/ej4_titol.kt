package controllers.ej4






/*FUNCION*/
fun titol(text: String) {
    // Amplio pantalla
    val ampliopantalla = 80

    // Longitud texto
    val longitudTexto = text.length

    // calcula centrado
    val espais = (ampliopantalla - longitudTexto) / 2

    // Muestra el texto centrado
    println(" ".repeat(espais) + text)
}