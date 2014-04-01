import java.awt.Color

Color.RED

import java.awt._

Font.BOLD

import java.awt.Color._
val c1 = RED // Color.RED
val c2 = decode("#ff0000")

import java.awt._

def handler(evt: event.ActionEvent) { // java.awt.event.ActionEvent
  println(evt)
  System.exit(0)
}

// Using javax.swing._ here means that listener code below fails...
//
// new event.ActionListener
//
// error: type ActionListener is not a member of package javax.swing.
// event
// Could improve following by using:
// import javax.swing.{JFrame, JButton}
import javax.swing.JFrame
import javax.swing.JButton
val frame = new JFrame




val button = new JButton("Exit")






frame.add(button)






button.addActionListener(new event.ActionListener {
  override def actionPerformed(evt: event.ActionEvent) {
    handler(evt)
  }
})
frame.pack
frame.setVisible(true)