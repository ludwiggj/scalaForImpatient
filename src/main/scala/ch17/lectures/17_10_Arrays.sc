import ch17.lectures.{Person, Student}

val students = new Array[Student](5)

// Error:(6, 35) type mismatch;
// found   : Array[ch17.lectures.Student]
// required: Array[ch17.lectures.Person]
// Note: ch17.lectures.Student <: ch17.lectures.Person, but class Array is invariant in type T.
// You may wish to investigate a wildcard type such as `_ <: ch17.lectures.Person`. (SLS 3.2.10)

// val people: Array[Person] = students

val people = new Array[Person](5)

//Error:(8, 38) type mismatch;
// found   : Array[ch17.lectures.Person]
// required: Array[ch17.lectures.Student]
// Note: ch17.lectures.Person >: ch17.lectures.Student, but class Array is invariant in type T.
// You may wish to investigate a wildcard type such as `_ >: ch17.lectures.Student`. (SLS 3.2.10)

// val studentz: Array[Student] = people

val z: Student => Person = (y) => new Person(y.name)

// This is OK with List() because it's immutable
val listStudents: List[Student] = List[Student](new Student("Neil"))
var listPersons: List[Person] = listStudents
// This is OK, because :+ returns a new list
listPersons = listPersons :+ new Student("Mike")
listStudents

import scala.collection.mutable

// But not allowed if it is a mutable list!
// val list:mutable.LinkedList[Person] = new mutable.LinkedList[Student]()