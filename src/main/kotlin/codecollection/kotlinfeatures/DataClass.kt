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

    demonstrateToString(person1, person2)
    demonstrateToEquals(person1, person2, person3)
    demonstrateToHashCode(person1, person2, person3)
    demonstrateToCopy(person1)
    demonstrateToDestructuring(person1)
}

fun demonstrateToString(person1: Person, person2: Person) {
    // toString() - automatically generated
    println("\n=== toString() ===")
    println("Person 1: $person1")
    println("Person 2: $person2")
    // Output:
    // Person 1: Person(firstName=Alice, age=30, email=alice@example.com)
    // Person 2: Person(firstName=Bob, age=32, email=bob@example.com)
}

fun demonstrateToEquals(person1: Person, person2: Person, person3: Person) {
    // equals() - automatically generated
    println("\n=== equals() ===")
    println("person1 == person3: ${person1 == person3}") // true
    println("person1 == person2: ${person1 == person2}") // false
}

fun demonstrateToHashCode(person1: Person, person2: Person, person3: Person) {
    // hashCode() - automatically generated
    println("\n=== hashCode() ===")
    println("person1.hashCode() equals person3.hashCode(): ${person1.hashCode() == person3.hashCode()}") // true

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
    println("person3 salary: ${salary[person3]}") // 30000, because person3 equals person1 (same hashCode and equals)

    // Important! The use "var" is not recommended in the data classes.
    println("\n=== Mutation properties: ===")
    val mutablePerson = MutablePerson("Charlie", 35, "charlie@example.com")
    val roleMap = hashMapOf(mutablePerson to "Developer")
    println("before mutation: ${mutablePerson.hashCode()}")
    mutablePerson.age = 36
    println("after mutation: ${mutablePerson.hashCode()}") // Different!
    println("Map size: ${roleMap.size}") // Map still contains the entry but can't find it.
}

fun demonstrateToCopy(person1: Person) {
    // copy() - automatically generated.
    // Attention! It is shallow copy. See example
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
}

fun demonstrateToDestructuring(person1: Person) {
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

