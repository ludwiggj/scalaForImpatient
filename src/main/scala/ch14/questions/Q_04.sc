abstract class Item

case class Article(description: String, price: Double) extends Item

case class Bundle(description: String, discount: Double, items: Item*) extends Item

case class Multiple(number: Int, item: Item) extends Item


val bundle = Bundle("Fathers day special", 20.0,
  Article("Scala for the Impatient", 39.95),
  Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Jinipero Gin", 32.95)
  )
)

val anotherBundle = Bundle("Fathers day special", 20.0,
  Article("Scala for the Impatient", 39.95),
  Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Jinipero Gin", 32.95)
  ),
  Article("Golf and Socks", 9.95)
)

def price(it: Item): Double = it match {
  case Article(_, p) => p
  case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
  case Multiple(number, item) => number * price(item)
}

price(bundle)
price(anotherBundle)

price(Multiple(2, bundle))
price(Multiple(3, anotherBundle))

price(Article("Scala for the Impatient", 39.95))
price(Multiple(9,Article("Scala for the Impatient", 39.95)))
price(Multiple(3,Multiple(3,Article("Scala for the Impatient", 39.95))))
