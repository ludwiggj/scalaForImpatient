val pattern = "([0-9]+) ([a-z]+)".r

"99 bottles" match {
    case pattern(num, items) =>
      s"There are $num green $items, sitting on a wall"
    case _ => "Something else"
}