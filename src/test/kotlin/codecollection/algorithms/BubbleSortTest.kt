package codecollection.algorithms

import kotlin.test.Test
import kotlin.test.assertEquals

class BubbleSortTest {

    @Test
    fun `sorts an unsorted list`() {
        val input = listOf(5, 2, 9, 1, 3)
        val expected = listOf(1, 2, 3, 5, 9)
        assertEquals(expected, bubbleSort(input))
    }

    @Test
    fun `returns the same list when already sorted`() {
        val input = listOf(1, 2, 3, 4)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, bubbleSort(input))
    }

    @Test
    fun `returns empty list when input is empty`() {
        val input = emptyList<Int>()
        val expected = emptyList<Int>()
        assertEquals(expected, bubbleSort(input))
    }

    @Test
    fun `sorts list with duplicates`() {
        val input = listOf(3, 1, 2, 1, 3)
        val expected = listOf(1, 1, 2, 3, 3)
        assertEquals(expected, bubbleSort(input))
    }
}