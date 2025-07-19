package codecollection.snippets.strings

fun String.replaceMultipleSpaces(): String {
    return this.replace(Regex("\\s+"), " ").trim()
}
