//6. Write an enumeration describing the four playing card suits so that the toString
//method returns ♣, ♦, ♥, or ♠.

object PlayingCardSuit extends Enumeration {
  type PlayingCardSuit = Value
  val Heart = Value("\u2665")
  val Club = Value("\u2663")
  val Diamond = Value("\u2666")
  val Spade = Value("\u2660")
}

// Q7 Implement a function that checks whether a card suit value from the preceding
//    exercise is red.
//    NOTE: Adding methods to enums a la Java is not trivial, so
//    writing a separate method for now...

import PlayingCardSuit._

def isRed(suit: PlayingCardSuit) = {
  (suit == Heart) || (suit == Diamond)
}

for (s <- PlayingCardSuit.values) println(s"${s.id}: $s isRed=${isRed(s)}")


