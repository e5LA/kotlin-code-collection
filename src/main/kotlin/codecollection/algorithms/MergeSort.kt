package codecollection.algorithms

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list

    val middle = list.size / 2
    val left = mergeSort(list.subList(0, middle))
    val right = mergeSort(list.subList(middle, list.size))

    return merge(left, right)
}

private fun merge(left: List<Int>, right: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) {
            result.add(left[i++])
        } else {
            result.add(right[j++])
        }
    }

    while (i < left.size) result.add(left[i++])
    while (j < right.size) result.add(right[j++])

    return result
}
