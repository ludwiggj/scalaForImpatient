//3. Define an Origin object that extends java.awt.Point. Why is this not actually a
//good idea? (Have a close look at the methods of the Point class.

/*

The "contract" of Java Point is here: http://docs.oracle.com/javase/7/docs/api/java/awt/Point.html.
Point is designed to be mutable and has mutators like setLocation(<overloaded>).
Given this information here are the disadvantages of using it like this and using it at all:
It's a mutable object which is even in Java is a thing to avoid.
When you are creating a singleton of the Point like this object Origin extends Point { } you can
only have a single Origin object in the entire application (not going to talk about classloaders and
their scope). If your intention is to have only a single Origin object you should still protect
yourself from mutability that Point comes with. Otherwise you are letting anybody change the origin.

I hope you see the contradiction by now: on one hand if you want to have a single origin in application
and be able to reason about it you would want your origin never change (immutable). On the other hand if
you don't want to have a single origin, then creating a singleton does not help at all.

-------------

I suppose I was thinking that you could have a single instance of an origin but perhaps that origin
could change over time. It seems like everyone is just assuming that because the object is named
'Origin' it will only ever have one value which shouldn't be mutable. I'm not 100% sure I agree with
this assumption- the question itself doesn't define that Origin only ever have a single value that
doesn't change.

-------------

Yes I agree with you that there is no requirement of immutability of Origin in the question. However,
names mean a lot to developers when they read code. We have to assume and expect certain behaviour when
seeing a name of a variable or a method. Perhaps a better name would be CurrentOrigin to indicate that
it can change. On the other hand mutability comes in flavours. You can have a var in Scala referencing
an immutable object (preferred usually) vs val referencing a mutable object (this case).

-------------

Functional programming and immutability make it easy to reason about your code because you don't have
to think about side effects and what state the Origin is in. You can have some other part of your code
deal with change propagation of an Origin.

-------------

Consider how would you test your code or replace Point implementation with another object if you are
sing statically initialized object and referencing it directly - not possible. You are already using
statically initialized object it invites for problems like these. This violates loose coupling principle.

-------------

Yeah, all really valid points - thanks for so much explanation. Just because you can do something doesn't
mean you should, and especially not without considering the consequences.
*/

import java.awt.Point

object Origin extends Point() {
}

Origin.toString
Origin.setLocation(2, 3)
Origin.toString