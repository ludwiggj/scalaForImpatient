//Q7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps
//Scaladoc.)
//(Write a for loop for computing the product of the Unicode codes of all letters
//in a string. For example, the product of the characters in "Hello" is 825152896.)

"Hello".map (_.toLong).product

"Hello".map ((x: Char) => x.toLong).product

