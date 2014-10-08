def digits(n: Int): Set[Int] = {
  if (n < 0) digits(-n)
  else if (n < 10) {
    println(s"Set($n)")
    Set(n)
  }
  else {
    println(s"digits($n / 10) + ${n % 10}")
    digits(n / 10) + (n % 10)
  }
}

digits(346523)

Set(3) + 4 + 6 + 5 + 2 + 3