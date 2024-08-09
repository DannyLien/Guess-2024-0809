package com.tom.guess

import kotlin.random.Random

class SecretNumber {
    val secret: Int = java.util.Random().nextInt(10) + 1
    var count = 0

    fun validate(number: Int): Int {
        count++
        return number - secret

    }//validate

}//SecretNumber

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.validate(2)} , count : ${secretNumber.count}" )

}//main



