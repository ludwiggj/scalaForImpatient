import ch17.lectures.types.{BigCompany, SmallCompany}

class Company[+T](val company: T) {

  // Error: covariant type T occurs in contravariant position in type T of value y
  // def partnerWithDuff(y: T) {
  // }

  def partnerWith[U >: T](y: U): Unit = {
    println(s"Is AnyRef? ${y.isInstanceOf[AnyRef]}")
    println(s"Is String? ${y.isInstanceOf[String]}")
    println(s"Is Company[BigCompany]? ${y.isInstanceOf[Company[BigCompany]]}")
    println(s"Is Company[SmallCompany]? ${y.isInstanceOf[Company[SmallCompany]]}")
    println(s"$company will partner with $y")
  }
}

// NOTE: definition of Function1 (a function that takes a single argument):

// trait Function1[-S, +T] {
//   def apply(x: S): T
// }

// Thus we solve using a lower bound: see partnerWith definition above

val smallCompany = new Company[SmallCompany](new SmallCompany)
val bigCompany = new Company[BigCompany](new BigCompany)

"SmallCompany -> BigCompany"

"bigCompany.partnerWith(smallCompany)"
bigCompany.partnerWith(smallCompany)

"bigCompany.partnerWith(bigCompany)"
bigCompany.partnerWith(bigCompany)

"bigCompany.partnerWith(\"Me\")"
bigCompany.partnerWith("Me")

"smallCompany.partnerWith(smallCompany)"
smallCompany.partnerWith(smallCompany)

"smallCompany.partnerWith(bigCompany)"
smallCompany.partnerWith(bigCompany)

"smallCompany.partnerWith(\"Me\")"
smallCompany.partnerWith("Me")