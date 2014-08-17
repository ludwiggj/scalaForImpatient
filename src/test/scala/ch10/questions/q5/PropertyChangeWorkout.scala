package ch10.questions.q5

import org.scalatest.{Matchers, FunSuite}
import java.beans.{PropertyChangeListener, PropertyChangeEvent}
import org.scalamock.scalatest.MockFactory
import java.awt.Point

class PropertyChangeWorkout extends FunSuite with MockFactory with Matchers {

  test("Test with real property change listener") {
    val beany = new Beany
    beany.addPropertyChangeListener(new PropertyChangeListener {
      def propertyChange(evt: PropertyChangeEvent) {
        println(evt.getOldValue)
        println(evt.getNewValue)
      }
    })
    beany.name = "You've changed"
  }

  test("Test with mocked property change listener") {
    val propertyChangeListener = mock[PropertyChangeListener]

    // Would like to write:
    // propertyChangeListener expects 'propertyChange where { (evt: PropertyChangeEvent) => (evt.getPropertyName == "name") }

    // But doesn't compile, so have to write:

    (propertyChangeListener.propertyChange _).expects(*)

    val beany = new Beany
    beany.addPropertyChangeListener(propertyChangeListener)
    beany.name = "You've changed"
  }


  test("Point test with real property change listener, x only") {
    val point = new ListenablePoint(2, 3)
    point.addPropertyChangeListener(new PropertyChangeListener {
      def propertyChange(evt: PropertyChangeEvent) {
        println(s"Property [${evt.getPropertyName}] changed from [${evt.getOldValue}] to [${evt.getNewValue}]")
      }
    })
    point.setLocationAndNotify(3, 3)
  }

  test("Point test 2 with real property change listener, x only") {
    val point = new Point(2, 3) with CanNotifyOnPropertyChange
    point.addPropertyChangeListener(new PropertyChangeListener {
      def propertyChange(evt: PropertyChangeEvent) {
        println(s"Property [${evt.getPropertyName}] changed from [${evt.getOldValue}] to [${evt.getNewValue}]")
      }
    })
    point.setLocationAndNotify(3, 3)
  }

  test("Point test with real property change listener, y only") {
    val point = new ListenablePoint(2, 3)
    point.addPropertyChangeListener(new PropertyChangeListener {
      def propertyChange(evt: PropertyChangeEvent) {
        println(s"Property [${evt.getPropertyName}] changed from [${evt.getOldValue}] to [${evt.getNewValue}]")
      }
    })
    point.setLocationAndNotify(2, 1)
  }

  test("Point test with real property change listener, x and y") {
    val point = new ListenablePoint(2, 3)
    point.addPropertyChangeListener(new PropertyChangeListener {
      def propertyChange(evt: PropertyChangeEvent) {
        println(s"Property [${evt.getPropertyName}] changed from [${evt.getOldValue}] to [${evt.getNewValue}]")
      }
    })
    point.setLocationAndNotify(0, 0)
  }
}