def ch(ch: Char) = {
  var sign = -99
  var digit = 0

  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }
  println(s"sign $sign digit $digit")
}

ch('+')
ch('k')
ch('6')