package kz.spatz.tjpk

class Adder(val name: String) {
    private var sum = 0
    private var numbers = 0

    fun sum(value: Int) {
        sum += value
        numbers++
    }

    fun getResult() = 1.0f * sum / numbers
}
