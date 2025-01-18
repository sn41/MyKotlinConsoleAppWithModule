package kz.spatz.tjpk

import java.io.File

fun main() {
    val file = File("src/main/resources/jokes.txt")
    readJokes(file)
}

//val jokes = readJokes(file)
//val type = runJokeTest(jokes)
//println("Формула вашего характера = $type !!!!")

fun runJokeTest(jokes: List<Joke>): String {
    val calculator = Calculator()

    for (indexOfJoke in jokes.indices) {
        val currentJoke = jokes[indexOfJoke]
        val text: String = currentJoke.toString()
        val isTrueAnswer = ask(text)
        if (isTrueAnswer) {
            calculator.sum(currentJoke.weights)
        }
    }
    return calculator.getResult()
}

val prompt = "\tНравиться, нажмите Y, Не нравиться - нажмите N\t>"

fun ask(message: String): Boolean {
    println()
    println(message)
    println()
    println(prompt)
    return getAnswer()
}

fun getAnswer():Boolean{
    val answer = readLine()
    val isYesAnswer = answer?.uppercase()?.contains("Y") ?: false
    return isYesAnswer
}