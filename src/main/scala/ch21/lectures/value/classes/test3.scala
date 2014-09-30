package ch21.lectures.value.classes

import Lengths.Metre
import Lengths.Centimetre

// Following fails to compile...

// type mismatch;
// found   : Int(6)
// required: ?{def toMetres: ?}
// Note that implicit conversions are not applicable because they are ambiguous:
// both method Metre in object Lengths of type (value: Double)ch21.lectures.value.classes.Lengths.Metre
// and method Centimetre in object Lengths of type (value: Double)ch21.lectures.value.classes.Lengths.Centimetre
// are possible conversion functions from Int(6) to ?{def toMetres: ?}

// println(s"6 cm = ${6.toMetres}")
//                     ^

object test3 extends App {
//  println(s"6 cm = ${6.toMetres}")
}