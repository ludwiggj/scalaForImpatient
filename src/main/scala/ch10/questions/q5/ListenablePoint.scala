package ch10.questions.q5

import java.awt.Point

class ListenablePoint(x: Int, y: Int) extends Point(x, y) with CanNotifyOnPropertyChange {
}