package codecollection.kotlinfeatures

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotSame
import kotlin.test.assertNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class DataClassTest {
    val person1 = Person(firstName = "Alice", age = 30, email = "alice@example.com")
    val person2 = Person(firstName = "Bob", age = 32, email = "bob@example.com")
    val person3 = Person(firstName = "Alice", age = 30, email = "alice@example.com")

    val mutablePerson = MutablePerson("Charlie", 35, "charlie@example.com")

    val address = Address("New York", "Washington Street")

    val employee1 = Employee("Developer", person1, address)
    val employeeDefault = Employee(person = person1, address = address)

    @Test
    fun `should create person with correct properties`() {
        assertEquals("Alice", person1.firstName)
        assertEquals(30, person1.age)
        assertEquals("alice@example.com", person1.email)
    }

    @Test
    fun `toString() should return formatted string`() {
        assertEquals(
            "Person(firstName=Alice, age=30, email=alice@example.com)",
            person1.toString(),
        )
    }

    @Test
    fun `equals should work correctly for same content`() {
        assertTrue(person1 == person3)
        assertFalse(person1 == person2)
    }

    @Test
    fun `hashCode should be same for equal objects`() {
        assertEquals(person1.hashCode(), person3.hashCode())
        assertNotEquals(person1.hashCode(), person2.hashCode())
    }

    @Test
    fun `should work correctly in hashset`() {
        val peopleSet = hashSetOf(person1, person2)
        assertTrue(peopleSet.contains(person1))
        assertTrue(peopleSet.contains(person2))
        assertTrue(peopleSet.contains(person3))
        assertEquals(2, peopleSet.size)
    }

    @Test
    fun `should work correctly in hashmap`() {
        val salary =
            hashMapOf(
                person1 to 30000,
                person2 to 27000,
            )
        assertEquals(30000, salary[person1])
        assertEquals(27000, salary[person2])
        assertEquals(30000, salary[person3])
        assertEquals(2, salary.size)
    }

    @Test
    fun `mutation var properties should break hashmap key`() {
        val testMap = hashMapOf(mutablePerson to "Developer")
        assertEquals("Developer", testMap[mutablePerson])
        mutablePerson.age = 36
        assertNull(testMap[mutablePerson])
    }

    @Test
    fun `mutation var properties should change hashCode()`() {
        val originalHashCode = mutablePerson.hashCode()
        mutablePerson.age = 36
        val newHashCode = mutablePerson.hashCode()
        assertNotEquals(originalHashCode, newHashCode)
    }

    @Test
    fun `copy() should create new instance with identical properties`() {
        val copy = person1.copy()
        assertEquals(person1, copy)
        assertNotSame(person1, copy)
    }

    @Test
    fun `copy() should create new instance with updated properties`() {
        val updated = person1.copy(email = "new.alice@example.com")
        assertEquals(person1.firstName, updated.firstName)
        assertEquals(person1.age, updated.age)
        assertEquals("new.alice@example.com", updated.email)
        assertEquals("alice@example.com", person1.email)
    }

    @Test
    fun `copy() should perform shallow copy of reference types`() {
        val employee2 = employee1.copy()

        assertNotSame(employee1, employee2)
        assertSame(employee1.person, employee2.person)
        assertSame(employee1.address, employee2.address)
    }

    @Test
    fun `mutation of referenced objects should affect the original and its copy`() {
        val employee2 = employee1.copy()
        employee2.address.street = "Park Avenue"
        assertEquals("Park Avenue", employee1.address.street)
        assertEquals("Park Avenue", employee2.address.street)
    }

    @Test
    fun `should use default value when not specified`() {
        assertEquals("Intern", employeeDefault.position)
    }

    @Test
    fun `copy() use default value`() {
        val copiedEmployee = employeeDefault.copy()
        assertEquals("Intern", copiedEmployee.position)
    }

    @Test
    fun `destructuring should work correctly`() {
        val (name, age, email) = person1
        assertEquals("Alice", name)
        assertEquals(30, age)
        assertEquals("alice@example.com", email)
    }

    @Test
    fun `componentN() should work correctly`() {
        assertEquals("Alice", person1.component1())
        assertEquals(30, person1.component2())
        assertEquals("alice@example.com", person1.component3())
    }
}
