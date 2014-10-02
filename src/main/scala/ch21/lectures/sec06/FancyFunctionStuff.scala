package ch21.lectures.sec06

object FancyFunctionStuff extends App {
  type fnWith3IntParams = (Int, Int, Int) => Int
  def tripler: fnWith3IntParams = _ + _ + _

  // Following line doesn't compile...
  // Expression of type (Int, Int) => Int doesn't conform to expected type fnWith3IntParams

  // def tripler2: fnWith3IntParams = _ + _

  def tripler3: fnWith3IntParams = (x: Int, y: Int, z: Int) => x + y

  println(tripler(1, 2, 3))
  println(tripler3(1, 2, 3))

  type fnWith2IntParams = (Int, Int) => Int
  def addPair: fnWith2IntParams = _ + _

  println(addPair(3, 7))

  type fnWithSingleIntParam = (Int) => Int
  def doubleNum: fnWithSingleIntParam = 2 * _

  println(doubleNum(9))

  type fnWithSingleIntParam2 = Int => Int
  def tripleNum: fnWithSingleIntParam2 = 3 * _

  println(tripleNum(9))
}