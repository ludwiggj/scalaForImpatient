package ch08.sec10

// Compile without, then with -Xcheckinit

class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class LazyCreature {
  lazy val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class FinalCreature {
  final val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}

class Ant extends Creature {
  override val range = 2
}

class Bug extends {
  override val range = 3
} with Creature

class Cow extends LazyCreature {
  override lazy val range = 4
}

class Doggone extends FinalCreature {
//  override val range = 7        // Not allowed, cannot override final member!
}

object Main extends App {
  val a = new Ant
  println(s"Ant range ${a.range}")
  println(s"Ant length ${a.env.length}")

  val b = new Bug
  println(s"Bug range ${b.range}")
  println(s"Bug length ${b.env.length}")

  val c = new Cow
  println(s"Cow range ${c.range}")
  println(s"Cow length ${c.env.length}")
}
