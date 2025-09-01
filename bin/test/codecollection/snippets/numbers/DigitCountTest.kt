package codecollection.snippets.numbers

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DigitCountTest {

    @Test
    fun `returns correct digit count for positive numbers`() {
        assertEquals(1, digitCount(5))
        assertEquals(2, digitCount(42))
        assertEquals(3, digitCount(999))
        assertEquals(6, digitCount(123456))
    }

    @Test
    fun `returns 1 for zero`() {
        assertEquals(1, digitCount(0))
    }

    @Test
    fun `throws for negative numbers`() {
        assertFailsWith<IllegalArgumentException> {
            digitCount(-7)
        }
    }
}
