package codecollection.snippets.strings

fun String.toCamelCase(): String =
    split(" ", "_", "-")
        .filter { it.isNotBlank() }
        .mapIndexed { index, word ->
            val lower = word.lowercase()
            if (index == 0) lower else lower.replaceFirstChar { it.uppercaseChar() }
        }.joinToString("")
