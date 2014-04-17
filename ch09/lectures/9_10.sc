val numPattern = "[0-9]+".r
val threeDigitNumberPattern = """[0-9]{3}""".r
val wsNumWsPattern = """\s+[0-9]+\s+""".r

for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
  println(matchString)


wsNumWsPattern.findAllIn("99 bottles, 98 bottles").toArray
val m1 = wsNumWsPattern.findFirstIn("99 bottles, 98 bottles")
val m2 = threeDigitNumberPattern.findFirstIn("99 bottles, 98 bottles")

numPattern.findPrefixOf("99 bottles, 98 bottles")
wsNumWsPattern.findPrefixOf("99 bottles, 98 bottles")


numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX")

numPattern.replaceAllIn("99 bottles, 98 bottles", "XX")

