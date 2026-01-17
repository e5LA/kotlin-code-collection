package codecollection.snippets.strings

import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToCamelCaseTest {

    @Test
    fun `converts space-separated to camelCase`() {
        assertEquals("helloWorld", "Hello world".toCamelCase())
    }

    @Test
    fun `converts underscore-separated to camelCase`() {
        assertEquals("myVariableName", "my_variable_name".toCamelCase())
    }

    @Test
    fun `converts dash-separated to camelCase`() {
        assertEquals("convertToCamelCase", "convert-to-camel-case".toCamelCase())
    }

    @Test
    fun `trims and ignores extra separators`() {
        assertEquals("multipleWordsHere", "  multiple___words--here ".toCamelCase())
    }
}
