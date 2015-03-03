package ch10.questions.q5

import java.beans.PropertyChangeSupport

class Beany extends PropertyChangeSupport(()) {
  private var privateName = "default"

  def name = privateName

  def name_=(newName: String) {
    val oldName = privateName
    privateName = newName
    firePropertyChange("name", oldName, newName)
  }
}