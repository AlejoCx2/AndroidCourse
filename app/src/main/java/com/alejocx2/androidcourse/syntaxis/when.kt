package com.alejocx2.androidcourse.syntaxis

fun main() {

    var name:String? = null

    // println(name!![3]) // !! Le asegura al interpreter que no sera nulo
    println(name?.get(3) ?: "Es nulo. XD'NT")

    var currentMonth = getMonth(10)
    println(currentMonth)
    var currentSemester = getSemeestre(10)
    println(currentSemester)
    println(result(22))
}

fun getMonth(month: Int): String {
    when (month) {
        1 -> return "Enero"
        2 -> return "Febrero"
        3 -> return "Marzo"
        4 -> return "Abril"
        5 -> return "Mayo"
        6 -> return "Junio"
        7 -> return "Julio"
        8 -> return "Agosto"
        9 -> return "Septiembre"
        10 -> return "Octubre"
        11 -> return "Noviembre"
        12 -> return "Diciembre"
        else -> return "Mes no valido"
    }
}

fun getSemeestre(month: Int): String {
    when (month) {
        1, 2, 3, 4, 5, 6 -> return "Primer Semestre"
        in 7..12 -> return "Segundo Semestre"
        !in 1..12 -> return "Mes no valido"
        else -> return "Tienen que haber un else"
    }
}

fun result(value: Any): Any{
    var result = when(value){
        is Int -> "Es un Int"
        is String -> "Es una String"
        is Boolean -> "Es un Boolean"
        else -> "Debe haber un else"
    }
    return result
}