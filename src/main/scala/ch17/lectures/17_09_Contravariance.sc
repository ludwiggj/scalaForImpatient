trait Friend[-T] {
  def befriend(someone: T): Unit = {
    println(s"I have befriended $someone")
  }
}

class Person(val name: String) extends Friend[Person] {
  override def toString = s"Person $name"
}

class Student(name: String) extends Person(name) {
  override def toString = s"Student $name"
}

def makeFriendsWith(s: Student, f: Friend[Student]): Unit = {
  f.befriend(s)
}
val student = new Student("Stu dent")
val terminator = new Person("Arnie")
makeFriendsWith(student, terminator)
makeFriendsWith(student, student)
// Note definition of Function1
// trait Function1[-T1, +R]

def friends(students: Array[Student], find: Function1[Student, Person]): Array[Person] ={
  for (s <- students) yield find(s)
}

def friendsSugared(students: Array[Student], find: Student => Person) = {
  friends(students, find)
}

def findStudentToPerson(s: Student) = new Person(s.name)

val students = Array(new Student("Vivian"), new Student("Mike"))

friends(students, findStudentToPerson)

def findPersonToStudent(p: Person) = new Student(p.name)

// Question: Can I call friends, passing in as second parameter?

// Consider definition of Function1: trait Function1[-T1, +R]

// So type of friends.find parameter is Function1[-Student, +Person]

// Also, Student <- Person

// So Function1[Person, Student] is a subtype of Function1[Student, Person],
// as -Student is contravariant, and +Person is covariant

friends(students, findPersonToStudent)

// And for experimentation purposes....

val people = Array(new Person("Arnie"), new Person("Sly"))

// Can't do this, as arrays are invariant!
// friends(people, findStudentToPerson)

def moreFriends(people: Array[Person], find: Person => Student) = {
  for (s <- people) yield find(s)
}

def moreFriendz: (Array[Person], (Person => Student)) => Array[Student] = (people, find) => {
  for (s <- people) yield find(s)
}

moreFriends(people, findPersonToStudent)

// This isn't allowed, as there's no guarantee that a person in the array is also a student
// moreFriends(people, findStudentToPerson)

// In terms of variance...

// Function1[Student, Person] is NOT a sub-type of Function1[-Person, +Student],
// as both parameter types fail the variance tests...