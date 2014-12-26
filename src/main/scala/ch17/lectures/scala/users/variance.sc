/*
I'm currently getting to grips with variance, especially how contravariance and covariance works with functions.
I understand the basics, but the following statement from "Scala for the Impatient" (page 239) still has me confused:

"Parameters are contravariant positions, and return types are covariant. However, inside a function parameter,
the variance flips - its parameters are covariant. For example, look at the foldLeft method of Iterable[+A]:

foldLeft[B](z: B)(op: (B, A) => B): B
            -          +  +     -   +

Note that A is now in a covariant position. These position rules are simple and safe..."

It's the flipping of variance and annotation of B's and A's in the op method that have me confused.

I have constructed and played with several code examples around this, which I won't post for the sake of brevity.
Suffice it to say that foldLeft behaved how I instinctively expected it to i.e. the op method parameter is in the
contravariant position, which provides the simple rules for defining which other functions are subtypes of
(B, A) => B and can thus be legitimately passed into foldLeft. These rules are based on the Function2 trait:

trait Function2[@scala.specialized -T1, @scala.specialized -T2, @scala.specialized +R]

which has the opposite variance to that expressed for the op method above...

So what does it actually mean to say that the variance flips? (I have found examples involving Cat's, Meows and
multiple annotations, but I found them very confusing). What effect does the annotation of the op method have?

(op: (B, A) => B): B
         +  +      -

Any advice would be greatly appreciated; a concrete (simple) example would take the biscuit!

*/

/*
Hello,

M1 requires certain inputs and promises certain outputs. Input is something that the method receives from elsewhere,
and output is something that the method gives to somewhere else.

Now ask whether method M2 can replace M1. To do so, M2 has to require no more and promise no less. M2 to can require
less and promise more. In other words, M2 needs to accept the same or more general input and provide the same or more
specific output.

Regular arguments are input and return values are output.

If a method takes a function as argument, however, then values the method passes to the function are output of the
function and values the method receives from the function are input to the method.

Best, Oliver

*/

/*

Hello, you probably wanted to say "are output of the method" instead of "are output of the function".

I'm adding somewhat lengthy example.

Let's say we have 3 types C <: B <: A. Let's also say F[T] is a type alias for a function type T => Int,
which is Function1[T, Int]. And let's say G[U] is a type alias for F[F[U]].

If someone expects a value of type B, we can give him a value of type C, because C <: B. Why? I'd say by principle,
or because Scala sub-typing conforms to LSP.

If someone expects a value/function of type B => Int (F[B]), we can give him a value/function of type A => Int (F[A]).
Why? He will see (or sees) it as a function B => Int, and will/may call it by passing it a value of type B (or at
least B, maybe a C). This is OK because the function is in fact of type A => Int, so it is in fact capable of accepting
values of type A, and he will (has to) give it at least a B. So from B <: A follows (A => Int) <: (B => Int). This rule
is (called) contra-variant, because the ordering of A and B is reversed. On the left side B is before A, on the right
side A is before B, they flip sides. If we use the F alias, we can write: from B <: A follows F[A] <: F[B]. We see that
F is used twice in the rule, once we replaced (or instantiated) the T in F[T] with A, once with B. Since the A and B
reversed/flipped the order on the place of the T parameter, the rule says that F is contra-variant in T, we write F[-T].

If someone expects a value/function of type (B => Int) => Int (F[F[B]]), we can give him a value/function of type
(C => Int) => Int (F[F[C]]). Why? He will see it as a function (B => Int) => Int and will/may call it by passing it a
value of type B => Int, i.e. a function. He can pass it any sub-type of B => Int, e.g. an A => Int (see above). Now the
function is in fact of type (C => Int) => Int, and when called, on the place of (C => Int) parameter it receives a
function which is in fact of type B => Int (at least). This is OK because the function will/may call the parameter
function (which it sees as C => Int) with a value of type C (at least), and the "real" function accepts at least a B.
So from C <: B follows (B => Int) <: (C => Int) and from it follows ((C => Int) => Int) <: ((B => Int) => Int).
Or: from C <: B follows F[B] <: F[C] from which follows F[F[C]] <: F[F[B]], which is a double-flip (B and C flip sides
twice). Shortcut is: from C <: B follows G[C] <: G[B]. This rule is (called) co-variant, and G is co-variant in U, we
write G[+U].

Regards,
Jan

---------
*/