package com.alejocx2.androidcourse.syntaxis

fun main(){
    conditional("Alejo")
    boolConditional()
}

fun conditional(name:String = "Pepe"){
    if (name.lowercase() == "alejo"){
        println("Bienvenido $name")
    } else {
        println("Fuera de aqui Mogle $name")
    }
}

fun boolConditional(){
    var myBoolean:Boolean = true

    if(myBoolean){
        println("Estoy Feliz")
    } else {
        println("Mhee...")
    }
}