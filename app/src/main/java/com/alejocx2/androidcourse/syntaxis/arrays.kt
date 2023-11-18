package com.alejocx2.androidcourse.syntaxis

fun main() {
    // Los array tienen tamaños fijos
    var names: Array<String> = arrayOf("Alejo", "Julian", "Meliwi")

    println(names.size)

    // Bucles
    for (pos in names.indices){
        println("Esta es la posicion $pos")
    }

    for ((pos,value) in names.withIndex()){
        println("Hola $value")
    }

    for (name in names){
        println("Easy Hello $name")
    }
}