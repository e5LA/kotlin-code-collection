package codecollection.snippets.strings

fun isPalindrome(input: String): Boolean {
    val filtered = input.filter { it.isLetterOrDigit() }.lowercase()
    return filtered == filtered.reversed()
}
