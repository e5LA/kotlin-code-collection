package codecollection.snippets.numbers

fun digitCount(n: Int): Int {
    require(n >= 0) { "Input must be non-negative" }
    return if (n == 0) 1 else kotlin.math.log10(n.toDouble()).toInt() + 1
}
