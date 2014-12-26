This is based on example from:

http://blogs.atlassian.com/2013/01/covariance-and-contravariance-in-scala/

1) Consider BadBox class, which shows problem with covariant type and setter equivalent method.

2) Consider AnotherBadBox class, which shows problem with contra-variance and return types.

3) So it looks like we have to make A invariant.

   As an aside, this is why it’s an absolutely terrible idea that Java’s arrays are covariant.
   That means that you can write code like the following:

   Integer[] ints = [1,2]
   Object[] objs = ints
   objs[0] = "I'm an integer!"

   Which will compile, but throw an ArrayStoreException at runtime. Nice.

   What to do?

   Actually, we don’t have to make container types with an “append”-like method invariant.
   Scala also lets us put type bounds on things. So if we modify Box as follows:

   class Box[+A]
   class BoundedBox[+A] {
     def set[B >: A](x:B) : Box[B] = {
       new Box()
     }
   }

   then it will compile. This ensures that the input type of the set method is properly contravariant.