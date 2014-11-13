package ch17.lectures.sec07

class Zygote

class Child(val age: Int) extends Zygote

class Father(age: Int) extends Child(age) {
  def child() = "child"
}

class Mother(age: Int) extends Child(age) {
  def child() = "child"
}

class GrandFather(age: Int) extends Father(age) {
  def grandchild() = "grandchild"
}

class GreatGrandFather(age: Int) extends GrandFather(age) {
  def greatgrandchild() = "greatgrandchild"
}


class GreatGreatGrandFather(age: Int) extends GreatGrandFather(age) {
  def greatgreatgrandchild() = "greatgreatgrandchild"
}

trait Wrinkly {
  def wrinkle() = "crack"
}

trait Chirpy {
  def laugh() = "ha ha"
}

// Zygote
//   ^
// Child----
//   ^      ^
// Father Mother
//   ^
// GrandFather
//   ^
// GreatGrandFather
//   ^
// GreatGreatGrandFather

object Bounds {
  // Upper and lower bound specified
  def tellMyAge[T >: GrandFather <: Child](person: T) = {
    println(s"Age ${person.age}, ${person.getClass}")
  }

  def displayPerson[T >: GrandFather](person: T) = {
    println(s"${person.getClass}")
  }

  def oldOne[T >: GreatGrandFather <: GrandFather](person: T) = {
    println(s"Age ${person.age}, ${person.child()}, ${person.grandchild()}, ${person.getClass}")
  }

  // Upper bound with multiple traits
  def wrinkleLaugh[T <: GreatGreatGrandFather with Wrinkly with Chirpy](person: T) = {
    println(s"${person.greatgreatgrandchild()} ${person.laugh()} ${person.wrinkle()}")
  }
}

import Bounds._

object Main extends App {
  // Can't pass Zygote...
  // Error: inferred type arguments [ch17.lectures.sec07.Zygote] do not conform to method tellMyAge's
  //        type parameter bounds [T >: ch17.lectures.sec07.GrandFather <: ch17.lectures.sec07.Child]
  // tellMyAge(new Zygote())

  tellMyAge(new Child(12))
  tellMyAge(new Father(42))
  tellMyAge(new GrandFather(62))
  tellMyAge(new GreatGrandFather(87))
  tellMyAge(new GreatGreatGrandFather(103))
  tellMyAge(new Mother(37))

  displayPerson(new Child(12))
  displayPerson(new Father(32))
  displayPerson(new Mother(32))
  displayPerson(new GreatGreatGrandFather(102))

  oldOne(new GrandFather(62))
  oldOne(new GreatGrandFather(87))
  oldOne(new GreatGreatGrandFather(103))

  // Nope
  // wrinkleLaugh(new GrandFather(62))
  // wrinkleLaugh(new GreatGrandFather(62) with Wrinkly with Chirpy)
  // wrinkleLaugh(new GreatGreatGrandFather(162) with Wrinkly)
  wrinkleLaugh(new GreatGreatGrandFather(162) with Wrinkly with Chirpy)
}