package com.alejocx2.androidcourse.syntaxis

// VARIABLES
/**
 * val: Contante
 * var: Variable
 */

fun main() {
    showMyAge(22)
    var suma = myAdd(2, 3)
    println("la suma es $suma")
}

fun showMyAge(currentAge: Int = 30) {
    println("Tengo $currentAge años")
}

fun myAdd(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun variableNumerica() {
    /**
     * Numericas
     */
    val age: Int = 22

    var age2 = 34
    age2 = 22

    val floatExample: Float = 30.5f
    val doubleExample: Double = 2342.23423423

    println(age2)

    var suma: Int = age2 + floatExample.toInt()
    var suma2 = age2 + floatExample
    println(suma)
    println(suma2)
}

fun variablesAlfanumericas() {
    /**
     * Alfanumericas
     */
    val charExample: Char = 'e'
    val stringExample: String = "Hello World" // las comilñlas dobles son importanmtes

    println(stringExample)
}

fun variablesBool() {
    val name = "AlejoCx2"

    /**
     * Booleanas
     */
    val boolExample: Boolean = false

    println("Hola me llamo $name, Bye")
}