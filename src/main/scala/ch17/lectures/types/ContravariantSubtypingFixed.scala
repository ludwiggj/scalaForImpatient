package ch17.lectures.types

// Contravariant orders types from more generic to more specific.

// By making T contravariant,
// if S is a subtype of T
// then NetworkChannel[T] is a subtype of NetworkChannel[S]

trait NetworkChannel[-T] {

  // write supplied argument to network channel
  def write(x: T)
}

// Thus if  String -> AnyRef
// then     NetworkChannel[AnyRef] -> NetworkChannel[String]

class AnyRefChannel extends NetworkChannel[AnyRef] {

  // I can write AnyRefs
  override def write(x:AnyRef): Unit = {
    println(s"Writing $x to NetworkChannel[AnyRef]")
  }
}

class StringChannel extends NetworkChannel[String] {

  // I can write Strings
  override def write(x:String): Unit = {
    println(s"Writing $x to NetworkChannel[String]")
  }
}

class StringChannelBufferControl {
  def control(channel: NetworkChannel[String]): Unit = {
    channel.write("Sending Control Signal")
    channel.write("[Control]")
  }
}

class AnyRefChannelBufferControl {
  def control(channel: NetworkChannel[AnyRef]): Unit = {
    channel.write("Sending Control Signal")
    channel.write(new Integer(281))
  }
}

object Main extends App {
  // We know that String is a subtype of AnyRef in Scala.

  // How come NetworkChannel[AnyRef] can be a subtype of NetworkChannel[String]?

  // Consider what you can do with each channel.

  // NetworkChannel[String] accepts an argument of type String
  // and writes it to the network channel.
  val stringChannel = new StringChannel
  stringChannel.write("Hello")

  // But you cannot write an integer to a string channel, as it's a type mismatch
  // stringChannel.write(new Integer(3))

  // NetworkChannel[AnyRef] accepts an argument of type AnyRef
  // and writes it to the network channel.
  val anyRefChannel = new AnyRefChannel
  anyRefChannel.write("Hi there")

  // This time we can write an Integer
  anyRefChannel.write(new Integer(3))

  // We can substitute NetworkChannel[AnyRef] for NetworkChannel[String]
  // since whatever can be done by NetworkChannel[String] can be done also
  // by NetworkChannel[AnyRef]
  //
  // i.e. NetworkChannel[AnyRef] can also write strings

  val stringChannelBufferControl = new StringChannelBufferControl

  stringChannelBufferControl.control(stringChannel)
  stringChannelBufferControl.control(anyRefChannel)

  // But note that the reverse is not true i.e. we cannot substitute
  // NetworkChannel[String] for NetworkChannel[AnyRef], because
  // NetworkChannel[AnyRef] can write Integers to the channel (for
  // example), but NetworkChannel[String] cannot; it can only write
  // strings. Thus:

  val anyRefChannelBufferControl = new AnyRefChannelBufferControl

  anyRefChannelBufferControl.control(anyRefChannel)

  // We can not use NetworkChannel[String] instead of
  // NetworkChannel[AnyRef] since it only accepts strings.

  // Error:(54, 37) type mismatch;
  // found   : A$A158.this.StringChannel
  // required: A$A158.this.NetworkChannel[AnyRef]
  // anyRefChannelBufferControl.control(stringChannel)

  // anyRefChannelBufferControl.control(stringChannel)
}