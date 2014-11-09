val f: PartialFunction[Char, Int] =
{case '+' => 1; case '-' => -1}

f('-')

f.isDefinedAt('0')

"-3+4".collect(f)

f('0')