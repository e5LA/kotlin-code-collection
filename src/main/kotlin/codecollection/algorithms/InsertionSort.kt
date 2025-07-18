fun insertionSort(list: List<Int>): List<Int> {
    if (list.size <= 1) return list
    
    val result = list.toMutableList()
    
    for (i in 1 until result.size) {
        val key = result[i]
        var j = i - 1
        
        while (j >= 0 && result[j] > key) {
            result[j + 1] = result[j]
            j--
        }
        result[j + 1] = key
    }
    
    return result
}