// Variance

import ch17.lectures.{Person, Student}

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
// Fix by making T covariant

class PermissivePair[+T](val first: T, val second: T) {
  override def toString = s"Pair [$first, $second]"
}

def makeFriendsPermissively(p: PermissivePair[Person]): Unit = {
  println(s"$p should make friends with each other")
}
makeFriendsPermissively(new PermissivePair[Person](p1, p2))
makeFriendsPermissively(new PermissivePair[Person](s1, s2))
makeFriendsPermissively(new PermissivePair[Student](s1, s2))
