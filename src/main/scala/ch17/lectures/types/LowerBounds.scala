package ch17.lectures.types

class Company[+T](val company: T) {

  def partnerWith[U >: T](y: U): Unit = {
    println(s"$company will partner with $y")
  }
}

class BigCompany {
  def noOfEmployees = 100000
  override def toString() = s"[Company with ${noOfEmployees} employees]"
}
class SmallCompany extends BigCompany {
  override def noOfEmployees = 25
}

object Main extends App {
  // "SmallCompany -> BigCompany"

  val smallCompany = new Company[SmallCompany](new SmallCompany)
  val bigCompany = new Company[BigCompany](new BigCompany)

  bigCompany.partnerWith(smallCompany)

  bigCompany.partnerWith(bigCompany)

  bigCompany.partnerWith("Me")

  smallCompany.partnerWith(smallCompany)

  smallCompany.partnerWith(bigCompany)

  smallCompany.partnerWith("Me")
}