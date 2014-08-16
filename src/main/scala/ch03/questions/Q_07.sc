//7. Write a code snippet that produces all values from an array with duplicates
//   removed. (Hint: Look at Scaladoc.)

def removeDuplicates(a: Array[Int]) = {
  a.distinct
}

removeDuplicates(Array(1,2,3,4,6,1,3,7,9,1,2,6))