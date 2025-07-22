package codecollection.snippets.strings

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPalindromeTest {

    @Test
    fun testPalindromeWithSimpleWord() {
        assertTrue(isPalindrome("madam"))
    }

    @Test
    fun testPalindromeWithPunctuation() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun testNonPalindrome() {
        assertFalse(isPalindrome("hello"))
    }
}
