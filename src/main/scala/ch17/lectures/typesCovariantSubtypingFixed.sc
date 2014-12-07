import ch17.lectures.types.{SmallCompany, BigCompany}

// By making T covariant,
// if   SmallCompany -> BigCompany
// then Company[SmallCompany] -> Company[BigCompany]
class Company[+T](val company: T)

class Investor(val company: Company[BigCompany])

val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)

val smallInvestor:Investor = new Investor(littleCompany)