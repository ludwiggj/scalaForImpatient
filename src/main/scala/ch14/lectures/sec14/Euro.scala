package ch14.lectures.sec14

case class Dummy(str: String)

//Error:(3, 54) illegal inheritance from sealed class Amount
//                                                     ^
//case class Euro(value: Double, unit: String) extends Amount