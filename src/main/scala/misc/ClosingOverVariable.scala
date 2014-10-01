package misc

object ClosingOverVariable extends App {

  def doNotDoThis() {
    val values = Array(100, 110, 120)
    val funcs = collection.mutable.Buffer[() => Int]()
    var value = 0
    var i = 0
    while (i < values.length) {
      value = values(i)
      funcs += (() => value)
      i += 1
    }
    funcs foreach (f => println(f()))
  }

  def generatesRunTimeException() {
    val values = Array(100, 110, 120)
    val funcs = collection.mutable.Buffer[() => Int]()
    var i = 0
    while (i < values.length) {
      funcs += (() => values(i))
      i += 1
    }
    funcs foreach (f => println(f()))
  }

  def idiomatically() {
    import collection.mutable.Buffer
    val values = List(100, 110, 120)
    val funcs = Buffer[() => Int]()

    for(v <- values) funcs += (() => v)
    funcs foreach ( f => println(f()) )
  }

  doNotDoThis()
  idiomatically()
  generatesRunTimeException()
}