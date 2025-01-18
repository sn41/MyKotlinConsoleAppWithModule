 package kz.spatz.tjpk

class Calculator() {
    private val adder = Array(types.size) {
        Adder(types[it])
    }

    fun sum(weights: IntArray) {
        for (index in adder.indices) {
            adder[index].sum(weights[index])
        }
    }

    fun getResult(): String {
        var indexOfMax = 0
        var max = 0f
        adder.forEachIndexed { index, summator ->
            val summatorValue = summator.getResult()
            if (max < summatorValue) {
                max = summatorValue
                indexOfMax = index
            }
        }

        return types[indexOfMax]
    }

}