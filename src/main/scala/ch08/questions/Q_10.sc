//10. The file scala/collection/immutable/Stack.scala contains the definition
//    class Stack[A] protected (protected val elems: List[A])
//    Explain the meanings of the protected keywords. (Hint: Review the discussion
//    of private constructors in Chapter 5.)

class Shape protected (protected val vertices: Int) {
  override def toString = s"A shape with $vertices vertices"
}

// constructor Shape in class Shape cannot be accessed in object
// Access to protected constructor Shape not permitted because
// enclosing object $iw is not a subclass of class Shape where
// target is defined

// new Shape(1)

class Circle extends Shape(0) {
  override def toString = s"A circle with $vertices vertices"
}
new Circle

// value vertices in class Shape cannot be accessed in Circle
// Access to protected value vertices not permitted because
// enclosing object $iw is not a subclass of class Shape
// where target is defined

// (new Circle).vertices