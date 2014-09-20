// Obtain largest element of an array with reduceLeft

List(3, 5, 0, -1, 23, 7) reduceLeft( (x, y) => if (x <= y) x else y )