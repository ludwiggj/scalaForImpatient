//Q6. Write a for loop for computing the product of the Unicode codes of all letters
//in a string. For example, the product of the characters in "Hello" is 825152896.

val str = "Hello"
var sum = 1L

for (i: Char <- str) sum = sum * i

sum