package misc.implicits

object ActionExample extends App {

  case class Request(msg: String)

  implicit val request = Request("first request")

  case class Result(msg: String)

  case class Action(result: Result)

  object Action {
    def apply(block: Request => Result): Action = {
      val result = block(implicitly[Request])
      new Action(result)
    }
  }

  val action = Action { request =>
    Result("Got request [" + request + "]")
  }

  // implicitly means request is used
  println(action)

  val request2 = Request("second request")

  val action2 = Action { request2 =>
    Result("Got request [" + request2 + "]")
  }

  // Again, implicitly means request is still used
  println(action2)

  object AlternativeAction {
    def apply(block: Request => Result)(implicit value: Request): Action = {
      val result = block(value)
      new Action(result)
    }
  }

  // second request used here, since explicitly passed
  val alternativeAction = AlternativeAction { implicit request =>
    Result("Got request [" + request + "]")
  }(request2)

  println(alternativeAction)

  // Again, second request used here, since explicitly passed
  val alternativeAction2 = AlternativeAction { request =>
    Result("Got request [" + request + "]")
  }(request2)
  println(alternativeAction2)

  // Request is not passed this time, so first request is used implicitly
  val alternativeAction3 = AlternativeAction { request =>
    Result("Got request [" + request + "]")
  }
  println(alternativeAction3)
}