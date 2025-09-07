package codecollection.snippets.strings

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsPalindromeTest {

    @Test
    fun `recognizes simple word palindrome`() {
        assertTrue(isPalindrome("madam"))
    }

    @Test
    fun `recognizes palindrome with punctuation and spaces`() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun `recognizes non-palindrome`() {
        assertFalse(isPalindrome("hello"))
    }
}
