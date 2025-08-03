package codecollection.algorithms

import java.util.Collections

fun selectionSort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list
    val result = list.toMutableList()
    for (i in 0 until result.size - 1) {
        var minIndex = i
        for (j in i + 1 until result.size) {
            if (result[j] < result[minIndex]) minIndex = j
        }
        if (minIndex != i) Collections.swap(result, minIndex, i)
    }
    return result
}
