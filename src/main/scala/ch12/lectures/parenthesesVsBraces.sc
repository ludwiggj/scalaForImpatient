// Following statement is illegal
// (1; 2+3)
// Following generates a warning...
//<console>:8: warning: a pure expression does nothing in statement position; you
//  may be omitting necessary parentheses
//                {1; 2+3}
{1; 2+3}
(4)
(if (true) 3 else 2)

{1}     // block of code
{(0)}   // block of code with an expression
-1       // literal
(-2)     // expression
({-3})   // expression with a block of code
({(-4)}) // you get the drift...