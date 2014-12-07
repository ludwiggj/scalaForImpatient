import ch17.lectures.types.{SmallCompany, BigCompany}

class Company[T](val company: T)

class Investor(val company: Company[BigCompany])

val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)
val bigInvestor: Investor = new Investor(bigCompany)

//Error:(14, 49) type mismatch;
// found   : A$A5.this.Company[A$A5.this.SmallCompany]
// required: A$A5.this.Company[A$A5.this.BigCompany]
//Note: A$A5.this.SmallCompany <: A$A5.this.BigCompany, but class Company is invariant in type T.
//You may wish to define T as +T instead. (SLS 4.5)

val smallInvestor:Investor = new Investor(littleCompany)

