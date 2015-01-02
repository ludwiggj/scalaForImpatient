/*

QUESTION
--------

I'm currently getting to grips with variance, especially how contra-variance and covariance works with functions.
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
      +  +         -

Any advice would be greatly appreciated; a concrete (simple) example would take the biscuit!

ANSWER
------

Let's say we have 3 types:

   C <: B <: A

Let's also say F[T] is a type alias for a function type T => Int, which is Function1[T, Int].

And let's say G[U] is a type alias for F[F[U]].

(1) If someone expects a value of type B, we can give him a value of type C, because C <: B. Why? I'd say by principle,
or because Scala sub-typing conforms to LSP.

(2) If someone expects a value/function of type F[B] (i.e. B => Int), we can give him a value/function of type
F[A] (i.e. A => Int).

Why? He will see (or sees) it as a function B => Int, and will/may call it by passing it a value of type B (or at
least B, maybe a C, as C <: B). This is OK because the function is in fact of type A => Int, so it is in fact capable of
accepting values of type A, and he will (has to) give it at least a B. So from B <: A follows (A => Int) <: (B => Int).

NOTE: Although we can pass F[A], the body of function F[A] can only call methods on A permitted by A's type i.e. it
cannot call methods belonging to types B and C.

This rule is (called) contra-variant, because the ordering of A and B is reversed. On the left side B is before A, on
the right side A is before B, they flip sides. If we use the F alias, we can write: from B <: A follows F[A] <: F[B]. We
see that F is used twice in the rule, once we replaced (or instantiated) the T in F[T] with A, once with B. Since the A
and B reversed/flipped the order on the place of the T parameter, the rule says that F is contra-variant in T, we write
F[-T].

(3) If a function "doSomething" expects a value/function of type F[F[B]] (i.e. (B => Int) => Int) e.g.

def doSomething(inputFunction: (B => Int) => Int)

we can give it a value/function of type F[F[C]] i.e. ((C => Int) => Int).

Why? The code inside doSomething will see inputFunction as a function (B => Int) => Int and will/may call it by passing
it a value of type B => Int, i.e. a function. He can pass it any sub-type of B => Int, e.g. an A => Int (see (2) above).

Now the actual function passed in (inputFunction) is in fact of type (C => Int) => Int. When inputFunction is called,
for the parameter declared as (C => Int) it receives a function which is in fact of type B => Int (at least, since this
is the formal definition of the input parameter to the inputFunction function).

In fact, as deduced from above, given:

C <: B <: A

it follows due to contra-variance...

(A => Int) <: (B => Int) <: (C => Int)

Method doSomething can pass a function of types (A => Int) and (B => Int), and the actual function passed of type
(C => Int) => Int can accept both of these functions as its input parameter.

Thus, given:

                             C <: B
                       and   (B => Int) <: (C => Int)
it follows from above that   ((C => Int) => Int) <: ((B => Int) => Int).

Or, given:
                             C <: B
                       and   F[B] <: F[C]
it follows from above that   F[F[C]] <: F[F[B]]

This is a "double-flip" i.e. B and C flip sides twice.

Shortcut is: from C <: B follows G[C] <: G[B]. This rule is (called) co-variant, and G is co-variant in U,
we write G[+U].

END.

(NOTE: I now understand what is meant by variance 'flipping'
       Still not sure how this relates back to the foldLeft example

foldLeft[B](z: B)(op: (B, A) => B): B
            -          +  +     -   +

)
*/