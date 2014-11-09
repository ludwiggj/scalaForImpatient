val scores = Map("bob" -> 2, "bobby" -> 5, "bobbi" -> 1)

def getScore(name: String) = {
  scores.get(name) match {
    case Some(score) => println(s"$name scores $score")
    case None => println(s"No score for $name")
  }
}

def getAnotherScore(name: String) = {
  val score = scores.get(name)
  if (score.isEmpty) println(s"No score for $name")
  else println(s"$name scores ${score.get}")
}

def getScoreThree(name: String) = {
  val score = scores.get(name)
  val daScore = score.getOrElse("No score")
  println(s"$name scores $daScore")
}

def getScoreFour(name: String) = {
  val score = scores.getOrElse(name, "No score")
  println(s"$name scores $score")
}

def getScoreFive(name: String) = {
  for (score <- scores.get(name)) println(s"$name scores $score")
}

def getScoreSix(name: String) = {
  scores.get(name).foreach(x => println(s"$name scores $x"))
}

getScore("muppet")
getScore("bobbi")

getAnotherScore("moopet")
getAnotherScore("bobby")

getScoreThree("animal")
getScoreThree("bob")

getScoreFour("burt")
getScoreFour("bob")

getScoreFive("ernie")
getScoreFive("bob")

getScoreSix("oscar")
getScoreSix("bobbi")