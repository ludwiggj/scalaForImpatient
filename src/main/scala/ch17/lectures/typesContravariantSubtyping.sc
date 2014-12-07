trait NetworkChannel[T] {
  // write supplied argument to network channel
  def write(x: T)
}

class AnyRefChannel extends NetworkChannel[AnyRef] {
  override def write(x:AnyRef): Unit = {
  }
}

class StringChannel extends NetworkChannel[String] {
  override def write(x:String): Unit = {
  }
}

class BufferControl {
  def control(channel:NetworkChannel[String]): Unit = {
  }
}

val arc = new AnyRefChannel
val bc = new BufferControl

// Error:(27, 13) type mismatch;
// found   : A$A34.this.AnyRefChannel
// required: A$A34.this.NetworkChannel[String]
// Note: AnyRef >: String (and A$A34.this.AnyRefChannel <: A$A34.this.NetworkChannel[AnyRef]),
// but trait NetworkChannel is invariant in type T.
// You may wish to define T as -T instead. (SLS 4.5)

bc.control(arc)