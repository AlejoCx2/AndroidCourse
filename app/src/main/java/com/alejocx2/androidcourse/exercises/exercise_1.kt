package com.alejocx2.androidcourse.exercises

fun main(){
    val morninNotifications = 51
    val eveningNotifications = 135

    printNotificationSummary(morninNotifications)
    printNotificationSummary(eveningNotifications)
}

fun printNotificationSummary(numberOfMesseges: Int){
    // TODO
    if (numberOfMesseges > 99){
        println("Tienes +99 notificaciones. Atiende tu mobil")
    } else {
        println("tienes $numberOfMesseges notificaciones")
    }
}