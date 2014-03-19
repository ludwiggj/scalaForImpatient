def box(s : String) { // Look carefully: no =
  val border = "-" * s.length + "--\n"
  println("\n" + border + "|" + s + "|\n" + border)
}

def box2(s : String): Unit = { // Look carefully: no =
  val border = "-" * s.length + "--\n"
  println("\n" + border + "|" + s + "|\n" + border)
}

box("Fred")


box2("Wilma")

