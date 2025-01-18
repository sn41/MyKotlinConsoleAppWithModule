package kz.spatz.tjpk

public data class Joke(
    public val number: Int = 0,
    public val weights: IntArray = intArrayOf(),
    public val text: Array<String> = emptyArray(),
) {
    public constructor(text: List<String>, number: Int, weight: List<Int>) : this(
        number,
        weight.toIntArray(),
        text.toTypedArray()
    )

    public override fun toString(): String {
        return text.joinToString(separator = "\n")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Joke

        if (number != other.number) return false
        if (!weights.contentEquals(other.weights)) return false
        if (!text.contentEquals(other.text)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = number
        result = 31 * result + weights.contentHashCode()
        result = 31 * result + text.contentHashCode()
        return result
    }
}