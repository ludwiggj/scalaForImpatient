package ch14.questions.q9



object Main extends App {
  val l: List[Option[Int]] = List(Some(9), None, None, Some(45), None)

  for (elem <- l) println(s"Hi $elem")

  print(for { elem <- l } yield elem)
}

