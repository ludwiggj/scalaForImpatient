def product(s: String) = {
  def product(s: String, acc: Long): Long = {
    s match {
      case "" => acc
      case _ => product(s.tail, acc * s.head.toLong)
    }
  }
  product(s, 1L)
}

product("Hello")