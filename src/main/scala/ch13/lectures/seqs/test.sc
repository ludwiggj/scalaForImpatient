val a = 9 :: List(4, 2)

def sum2(lst: List[Int]): Int = lst match {
  case Nil => 0
  case h :: t => h + sum2(t)
}

//sum(a)
sum2(a)
//a.sum