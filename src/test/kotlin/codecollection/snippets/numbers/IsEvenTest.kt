package codecollection.snippets.numbers

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsEvenTest {

    @Test
    fun `should return true for even numbers`() {
        assertTrue(isEven(0))
        assertTrue(isEven(2))
        assertTrue(isEven(-4))
        assertTrue(isEven(100))
    }

    @Test
    fun `should return false for odd numbers`() {
        assertFalse(isEven(1))
        assertFalse(isEven(-3))
        assertFalse(isEven(99))
    }
}
