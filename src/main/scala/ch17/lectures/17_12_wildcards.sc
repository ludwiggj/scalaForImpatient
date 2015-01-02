// Variance

import ch17.lectures.{Person, Student}

// Previously (17_09_Covariance.sc) if Pair is invariant in T then
// makeFriends method, which takes Pair[Person], cannot take a
// Pair[Student]

class Pair[T](val first: T, val second: T) {
  override def toString = s"Pair [$first, $second]"
}

def makeFriends(p: Pair[Person]): Unit = {
  println(s"$p should make friends with each other")
}
val p1 = new Person("Paddington")
val p2 = new Person("Simon the Dancing")

val personPair: Pair[Person] = new Pair(p1, p2)
makeFriends(personPair)

val s1 = new Student("Stu")
val s2 = new Student("Dent")

val studentPair: Pair[Student] = new Pair(s1, s2)

// Doesn't work, as there is no relationship between
// Pair[Person] and Pair[Student]
// makeFriends(studentPair)

// But we can if we use wildcards...
// Example of wildcard _ for covariance
def letsBeBuddies(p: Pair[_ <: Person]): Unit = {
  println(s"$p are now buddies")
}
letsBeBuddies(personPair)
letsBeBuddies(studentPair)

// Example of _ for contravariance

import java.util.Comparator

def min[T](p: Pair[T])(comp: Comparator[_ >: T]) = {
  if (comp.compare(p.first, p.second) < 0) p.first else p.second
}

val personComparator: Comparator[Person] = {
  new Comparator[Person] {
    override def compare(o1: Person, o2: Person): Int = {
      o1.name.compare(o2.name)
    }
  }
}

val studentComparator: Comparator[Student] = {
  new Comparator[Student] {
    override def compare(o1: Student, o2: Student): Int = {
      o1.name.compare(o2.name)
    }
  }
}

// Student <: Person
min[Person](personPair)(personComparator)
// NOT allowed...
// min[Person](personPair)(studentComparator)
min[Student](studentPair)(studentComparator)
// Allowed due to contra-variant wildcard
min[Student](studentPair)(personComparator)