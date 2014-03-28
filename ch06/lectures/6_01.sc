object Accounts {
  // Following line (effectively object constructor) is only executed
  // when Accounts.newUniqueNumber() is called
  println(7)
  private var lastNumber = 0
  def newUniqueNumber() = { lastNumber += 1; lastNumber }
}

Accounts.newUniqueNumber()

Accounts.newUniqueNumber()