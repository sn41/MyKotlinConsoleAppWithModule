package kz.spatz.tjpk

import java.io.File

fun readJokes(file: File): List<Joke> {
    val jokes = mutableListOf<Joke>()
    val lines = file.readLines()
    val jokeLines = mutableListOf<String>()
    lines.forEach { line ->
        if (line.startsWith("#")) {
            val parts = line.split("$")
            val number = parts[0].replace("#", "").trim().toInt()
            val weights = parts[1].trim().split(".").map { it.toInt() }
            val joke = Joke(jokeLines, number, weights)
            jokes.add(joke)
            jokeLines.clear()
        } else {
            jokeLines.add(line)
        }
    }
    return jokes
}