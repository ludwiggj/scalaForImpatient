abstract class Item

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, discount: Double, items: Item*) extends Item


val bundle = Bundle("Fathers day special", 20.0,
  Article("Scala for the Impatient", 39.95),
  Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Jinipero Gin", 32.95)
  )
)

bundle match {
  case Bundle(_, _, Article(descr, _), _*) => descr
}

bundle match {
  case Bundle(_, _, art @ Article(_, _), rest) => art + s" rest(${rest})"
}

val anotherBundle = Bundle("Fathers day special", 20.0,
  Article("Scala for the Impatient", 39.95),
  Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Jinipero Gin", 32.95)
  ),
  Article("Golf and Socks", 9.95)
)

anotherBundle match {
  case Bundle(_, _, art @ Article(_, _), rest @ _*) => art + s" rest(${rest})"
}

// Following gives a match error...

// anotherBundle match {
//   case Bundle(_, _, art @ Article(_, _), rest) => art + s" rest(${rest})"
// }

def price(it: Item): Double = it match {
  case Article(_, p) => p
  case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
}

price(bundle)
price(anotherBundle)