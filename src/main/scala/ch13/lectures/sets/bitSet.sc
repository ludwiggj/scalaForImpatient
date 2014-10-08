import scala.collection.immutable.BitSet

val primebits = BitSet(2, 3, 5, 7, 11)
val evenBits = BitSet(0, 2, 4, 6, 8, 10)
val evenSet = Set(0, 2, 4, 6, 8, 10);

primebits & evenBits // BitSet(2)
primebits & evenSet // BitSet(2)

primebits &~ evenBits // BitSet(3, 5, 7, 11)
primebits &~ evenSet // BitSet(3, 5, 7, 11)