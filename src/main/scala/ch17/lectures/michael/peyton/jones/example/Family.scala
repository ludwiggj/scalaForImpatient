package ch17.lectures.michael.peyton.jones.example

class GrandParent
class Parent extends GrandParent
class Child extends Parent

class BoxCovariant[+T]
class BoxContravariant[-T]

object Main extends App {
  def foo(x : BoxCovariant[Parent]) : BoxCovariant[Parent] = identity(x)

  def bar(x : BoxContravariant[Parent]) : BoxContravariant[Parent] = identity(x)

  foo(new BoxCovariant[Child]) // success

  // foo(new BoxCovariant[GrandParent]) // type error

  // bar(new BoxContravariant[Child]) // type error

  bar(new BoxContravariant[GrandParent]) // success
}