//4. Define an abstract class Item with methods price and description. A SimpleItem is
//   an item whose price and description are specified in the constructor. Take
//   advantage of the fact that a val can override a def. A Bundle is an item that
//   contains other items. Its price is the sum of the prices in the bundle. Also
//   provide a mechanism for adding items to the bundle and a suitable description
//   method.

abstract class Item {
  def price: BigDecimal
  def description: String
}

class SimpleItem(val price: BigDecimal, val description: String) extends Item

val football = new SimpleItem(2.5, "Football")

football.price
football.description

class Bundle extends Item {
  private var items: List[Item] = List()

  def add(item: Item) = {
    items = items :+ item
  }

  def price = items.foldLeft(BigDecimal(0))(_ + _.price)
  def description = {
    var desc = s"A bundle of ${items.size} items as follows..."
    items map { item =>
      desc += s"\n  ${item.description}, price ${item.price}"
    }
    desc
  }
}

val bundle = new Bundle
bundle.add(football)
bundle.add(new SimpleItem(13.3, "Golden Boot"))
bundle.price
bundle.description







