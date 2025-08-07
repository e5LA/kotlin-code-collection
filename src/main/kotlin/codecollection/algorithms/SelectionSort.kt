package codecollection.algorithms

fun selectionSort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list
    val result = list.toMutableList()
    for (i in 0 until result.size - 1) {
        var minIndex = i
        for (j in i + 1 until result.size) {
            if (result[j] < result[minIndex]) minIndex = j
        }
        if (minIndex != i) result[minIndex] = result[i].also { result[i] = result[minIndex] }
    }
    return result
}
