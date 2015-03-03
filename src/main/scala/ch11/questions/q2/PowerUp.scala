package ch11.questions.q2

// import java.math.BigInteger

// Comment this out, as BigInt is now final in Scala 2.11

trait PowerUp
/*
trait PowerUp extends BigInt {
  def **(exp: Int) = pow(exp)
  def ^(exp: Int) = pow(exp)
}

object Main extends App {
  val y = new BigInt(new BigInteger("7")) with PowerUp

  println(y pow (2))
  println(y ** 3)
  println(y ^ 4)

  // precedence issues with ** and ^
  println(y pow 2 + 3)
  println(y ** 2 + 3)
  println(y ^ 2 + 3)
}
*/