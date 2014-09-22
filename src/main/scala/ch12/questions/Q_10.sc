// Implement an unless control abstraction that works like if, but with an inverted condition
// Does first parameter need to be a call by name parameter? Dp you need currying?

def unless(condition: => Boolean)(block: => Unit) {
  if (!condition) {
    block
  }
}

var x = 1
unless(x == 10) {
  println(s"$x does not equal 10")
}

def unless2(condition: => Boolean)(block: () => Unit) {
  if (!condition) {
    block()
  }
}

unless2(x == 10) {
  () => println(s"$x still does not equal 10")
}

def unless3(condition: => Boolean, block: () => Unit) {
  if (!condition) {
    block()
  }
}

unless3(x == 10, {
  () => println(s"$x really still does not equal 10")
})