package codecollection.algorithms

fun bubbleSort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list

    val result = list.toMutableList()
    val lastIndex = result.lastIndex

    repeat(result.size - 1) { i ->
        var isSwapped = false
        for (j in 0 until lastIndex - i) {
            if (result[j] > result[j + 1]) {
                result[j] = result[j + 1].also { result[j + 1] = result[j] }
                isSwapped = true
            }
        }
        if (!isSwapped) return result.toList()
    }

    return result.toList()
}
