import ch17.lectures.types.{SmallCompany, BigCompany}

class Company[+T](val company:T) {

  // Now restrict partnerWith

  // Company can have partnership with another company
  // but it must be a subtype of Company[BigCompany]
  def partnerWith[U <: Company[BigCompany]](y: U): Unit = {
    println("partnering with company")
  }
}

val bigCompany = new Company[BigCompany](new BigCompany)
val smallCompany = new Company[SmallCompany](new SmallCompany)

bigCompany.partnerWith(bigCompany)
bigCompany.partnerWith(smallCompany)
class CrappyCompany

val crappyCompany = new Company[CrappyCompany](new CrappyCompany)

// Error:(24, 13) inferred type arguments [A$A73.this.Company[A$A73.this.CrappyCompany]]
// do not conform to method partnerWith's type parameter bounds
// [U <: A$A73.this.Company[ch17.lectures.types.BigCompany]]

// bigCompany.partnerWith(crappyCompany)