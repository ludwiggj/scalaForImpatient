// Currying

def mul(x: Int, y: Int) = x * y

mul(6, 7)

def mulOneByOne(x: Int) = (y: Int) => x * y

mulOneByOne(6)(7)

def mulOneByOneSuccinct(x: Int)(y: Int) = x * y

mulOneByOneSuccinct(9)(5)