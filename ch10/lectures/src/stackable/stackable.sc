trait Munger {
  def munge(l : List[String]) : List[String]
}

trait Replace1 extends Munger {
  override def munge(l : List[String]) = l :+ "Replace1"
}

trait Replace2 extends Munger {
  override def munge(l : List[String]) = l :+ "Replace2"
}

//abstract override def munge required in the Stack* classes because they invoke
//abstract super.munge

trait Stack1 extends Munger {
  abstract override def munge(l : List[String]) = super.munge(l) :+ "Stack1"
}

trait Stack2Parent extends Munger {
  abstract override def munge(l : List[String]) = super.munge(l) :+ "Stack2Parent"
}

trait Stack2 extends Stack2Parent {
  abstract override def munge(l : List[String]) = super.munge(l) :+ "Stack2"
}

class Bottom {
  this : Munger =>

  def apply() {
    println(
      munge(List("bottom"))
    )
  }
}

(new Bottom with Replace1)()

// Replace1's munge is overridden and never runs
(new Bottom with Replace1 with Replace2)()

//Stack1 calls super.munge, which invokes the
//munge from the trait to the left
(new Bottom with Replace1 with Stack1)()

//Stack2's super.munge called to its superclass,
// whereas Stack2Parent's super.munge called the
// trait to the left
(new Bottom with Replace1 with Stack2)()
