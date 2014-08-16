// Default parameters...
def decorate(str: String, left: String = "[", right: String = "]") = left + str + right

// Use defaults
println(decorate("Hello"))

// Override defaults
println(decorate("Hello", "<<<", ">>>"))

// right is defaulted only
println(decorate("Hello", ">>>["))

// Named params, order doesn't have to match
println(decorate(left = "<<<", str = "Hello", right = ">>>"))

// Can override some by name, unnamed must come first
println(decorate("Hello", right = "]<<<"))