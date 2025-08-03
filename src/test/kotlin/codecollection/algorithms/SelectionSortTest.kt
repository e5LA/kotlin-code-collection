package codecollection.algorithms

import kotlin.test.Test
import kotlin.test.assertEquals

class SelectionSortTest {
    @Test
    fun `sorts an unsorted list`() {
        val input = listOf(5, 2, 9, 1, 3)
        val expected = listOf(1, 2, 3, 5, 9)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `returns the same list when already sorted`() {
        val input = listOf(1, 2, 3, 4)
        val expected = listOf(1, 2, 3, 4)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `returns empty list when input is empty`() {
        val input = emptyList<Int>()
        val expected = emptyList<Int>()
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `sorts list with duplicates`() {
        val input = listOf(3, 1, 2, 1, 3)
        val expected = listOf(1, 1, 2, 3, 3)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `sorts single element list`() {
        val input = listOf(42)
        val expected = listOf(42)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `sorts reverse sorted list`() {
        val input = listOf(5, 4, 3, 2, 1)
        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `sorts list with negative numbers`() {
        val input = listOf(-3, 1, -2, 5, 0)
        val expected = listOf(-3, -2, 0, 1, 5)
        assertEquals(expected, selectionSort(input))
    }

    @Test
    fun `sorts list with two elements`() {
        val input = listOf(2, 1)
        val expected = listOf(1, 2)
        assertEquals(expected, selectionSort(input))
    }
}
