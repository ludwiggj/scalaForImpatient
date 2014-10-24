val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

(list :\ List[Int]())(_ :: _)
(list :\ List[Int]())((a, b) => b :+ a)
(List[Int]() /: list)(_ :+ _)
(List[Int]() /: list)((a, b) => b +: a)