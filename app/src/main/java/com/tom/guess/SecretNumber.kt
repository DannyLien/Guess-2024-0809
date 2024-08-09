package com.tom.guess

import kotlin.random.Random

class SecretNumber {
    var secret: Int = java.util.Random().nextInt(10) + 1
    var count = 0

    fun validate(number: Int): Int {
        count++
        return number - secret

    }//validate

    fun reset() {
        count = 0
        secret = java.util.Random().nextInt(10) + 1

    }

}//SecretNumber

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.validate(2)} , count : ${secretNumber.count}")

}//main



