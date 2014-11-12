val l: List[Option[Int]] = List(Some(9), None, None, Some(45), None)

for (elem <- l) println(s"Hi $elem")

(for { elem <- l } yield elem getOrElse(0)).sum
(for { elemOpt <- l; elem <- elemOpt } yield elem).sum