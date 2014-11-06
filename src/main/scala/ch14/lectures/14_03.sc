def ch1(i: Char) = {
  var sign = -99
  var digit = 0

  i match {
    case '+' => sign = 1
    case '-' => sign = -1
    case ch  => digit = Character.digit(ch, 10)
  }
  println(s"sign $sign digit $digit")
}

def ch2(i: Char) = {
  var sign = -99
  var digit = 0

  i match {
    case '+' => sign = 1
    case '-' => sign = -1
    case ch if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }
  println(s"sign $sign digit $digit")
}

ch1('+')
ch1('k')
ch1('6')
ch2('+')
ch2('k')
ch2('6')