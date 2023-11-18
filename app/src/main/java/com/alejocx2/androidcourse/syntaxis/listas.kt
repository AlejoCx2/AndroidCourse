package com.alejocx2.androidcourse.syntaxis

fun main() {
    inmutableList()
    mutableList()
}

fun inmutableList() {
    // Inmutables
    val readOnly: List<String> = listOf("Alejo", "Julian", "Meliwi")
    println(readOnly)
    println("El ultimo es: "+readOnly.last())
    val filterExample = readOnly.filter { it.contains("a") }
    println("Filter $filterExample")

    readOnly.forEach { name -> println(name) }
}

fun mutableList(){
    val friends:MutableList<String> = mutableListOf("Alejo", "Julian", "Meliwi")
    println("Mutables: $friends")
    friends.add("Josecillo")
    friends.add(0,"David")
    println("Mutables: $friends")
    if (friends.isEmpty()){
        println("No tengo amikos. T_T")
    } else {
        print("Mis amigos son: ")
        friends.forEach { name -> println(name) }
    }
    friends.removeAt(1)
    println(friends)
}
