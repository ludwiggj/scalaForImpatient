import questions.q2.OrderedPoint

val pointList = List(
  new OrderedPoint(2, 3),
  new OrderedPoint(-2, 1),
  new OrderedPoint(6, 2),
  new OrderedPoint(2, 6),
  new OrderedPoint(6, 2)
)

println(new OrderedPoint < new OrderedPoint(0, 2))
println(new OrderedPoint(0, 1) < new OrderedPoint(-1, 2))

// Following fails with error message...
//
// <console>:10: error: diverging implicit expansion for
// type scala.math.Ordering[questions.q2.OrderedPoint]
// starting with method ordered in trait
// LowPriorityOrderingImplicits pointList.sorted[OrderedPoint]

// Return to this a lot later to see if I can understand it!
pointList.sorted[OrderedPoint]