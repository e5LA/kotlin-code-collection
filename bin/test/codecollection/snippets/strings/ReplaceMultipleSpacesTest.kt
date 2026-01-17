package codecollection.snippets.strings

import kotlin.test.Test
import kotlin.test.assertEquals

class ReplaceMultipleSpacesTest {

    @Test
    fun `replaces multiple spaces with one`() {
        val input = "This    is   a     test"
        val expected = "This is a test"
        assertEquals(expected, input.replaceMultipleSpaces())
    }

    @Test
    fun `handles leading and trailing spaces`() {
        val input = "   Kotlin   is   awesome   "
        val expected = "Kotlin is awesome"
        assertEquals(expected, input.replaceMultipleSpaces())
    }

    @Test
    fun `returns empty string when only spaces`() {
        assertEquals("", "     ".replaceMultipleSpaces())
    }

    @Test
    fun `handles empty string`() {
        assertEquals("", "".replaceMultipleSpaces())
    }
}
