// Data classes can't be abstract, open, sealed, or inner.
// The primary constructor must have at least one parameter.

package codecollection.kotlinfeatures

data class Person(
    val firstName: String,
    val age: Int,
    val email: String,
)

// Attention! The use "var" is not recommended in the data classes. See the example.
data class MutablePerson(
    var firstName: String,
    var age: Int,
    var email: String,
)

data class Address(
    var city: String,
    var street: String,
)

data class Employee(
    val position: String = "Intern", // default property
    val person: Person,
    val address: Address,
)

fun main() {
    println("=== BASIC DATA CLASS FEATURES ===")

    // Create instances
    val person1 = Person(firstName = "Alice", age = 30, email = "alice@example.com")
    val person2 = Person(firstName = "Bob", age = 32, email = "bob@example.com")
    val person3 = Person(firstName = "Alice", age = 30, email = "alice@example.com")

    // toString() - automatically generated
    println("\n=== toString() ===")
    println("Person 1: $person1")
    println("Person 2: $person2")
    // Output:
    // Person 1: Person(firstName=Alice, age=30, email=alice@example.com)
    // Person 2: Person(firstName=Bob, age=32, email=bob@example.com)

    // equals()
    println("\n=== equals() ===")
    println("person1 == person3: ${person1 == person3}") // true
    println("person1 == person2: ${person1 == person2}") // false

    // hashCode()
    println("\n=== hashCode() ===")
    println("hashCode person1: ${person1.hashCode()}")
    println("hashCode person2: ${person2.hashCode()}")
    println("hashCode person3: ${person3.hashCode()}") // same as person1.hashCode()
    // Output:
    // hashCode person1: -1399032001
    // hashCode person2: 531733799
    // hashCode person3: -1399032001

    // Checking in HashSet
    println("\n=== Checking in HashSet ===")
    val peopleSet = hashSetOf(person1, person2)
    println("set contains person1: ${peopleSet.contains(person1)}") // true
    println("set contains person3: ${peopleSet.contains(person3)}") // true, because hashCode() and equals() are the same
    // Output:
    // set contains person1: true
    // set contains person3: true

    // Checking in HashMap
    println("\n=== Checking in HashMap ===")

    val salary =
        hashMapOf(
            person1 to 30000,
            person2 to 27000,
        )

    println("person1 salary: ${salary[person1]}") // 30000
    println("person3 salary: ${salary[person3]}") // 30000, because is same key

    // Important! The use "var" is not recommended in the data classes.
    println("\n=== Mutation properties: ===")
    val mutablePerson = MutablePerson("Charlie", 35, "charlie@example.com")
    val testMap = hashMapOf(mutablePerson to "Developer")
    println("before mutation: ${testMap[mutablePerson]}") // Developer
    mutablePerson.age = 36
    println("after mutation: ${testMap[mutablePerson]}") // null, the key is "lost"

    // copy() Attention! It is shallow copy. See example
    println("\n=== copy() ===")

    val person1Updated = person1.copy(age = 31, email = "new.alice@example.com")

    println("Updated person 1: $person1Updated")
    // Output: Updated person 1: Person(firstName=Alice, age=31, email=new.alice@example.com)

    println("\n=== Shallow copy: ===")
    val originalAddress = Address("New York", "Washington Street")
    val employee1 = Employee("Developer", person1, originalAddress)
    val employee2 = employee1.copy()
    println("before mutation:")
    println("employee1: $employee1")
    println("employee2: $employee2")
    // employee1: Employee(position=Developer, person=Person(firstName=Alice, age=30, email=alice@example.com), address=Address(city=New York, street=Washington Street))
    // employee2: Employee(position=Developer, person=Person(firstName=Alice, age=30, email=alice@example.com), address=Address(city=New York, street=Washington Street))

    employee2.address.street = "Park Avenue"
    println("after mutation:")
    println("employee1: $employee1") // The street has changed too!
    println("employee2: $employee2")
    // employee1: Employee(position=Developer, person=Person(firstName=Alice, age=30, email=alice@example.com), address=Address(city=New York, street=Park Avenue))
    // employee2: Employee(position=Developer, person=Person(firstName=Alice, age=30, email=alice@example.com), address=Address(city=New York, street=Park Avenue))

    // Destructuring - automatically generated componentN() functions corresponding to the properties in their order of declaration.
    println("\n=== Destructuring: ===")
    val (name, age, email) = person1
    println("Destructured: name=$name, age=$age, email=$email")
    // Output: Destructured: name=Alice, age=30, email=alice@example.com

    // You can also use componentN() functions directly
    println("name: ${person1.component1()}")
    println("age: ${person1.component2()}")
    println("email: ${person1.component3()}")
    // Output:
    // name: Alice
    // age: 30
    // email: alice@example.com
}
