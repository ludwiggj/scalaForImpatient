import ch10.sec13._
val exception = new Exception with LoggedException
// Not allowed by compiler

// import javax.swing.JFrame
// val duffException = new JFrame with LoggedException

val exception2 = new Exception with LoggedException2
// Not allowed by compiler

//import javax.swing.JFrame
//val duffException2 = new JFrame with LoggedException2

// SelfTypes to implement circular traits
//val circle1 = new Gin with CircularA
//val circle2 = new Gin with CircularB
val circle3 = new Gin with CircularA with CircularB
val circle4 = new Gin with CircularB with CircularA