package codecollection.snippets.strings

fun String.replaceMultipleSpaces(): String =
    this.replace(Regex("\\s+"), " ").trim()
