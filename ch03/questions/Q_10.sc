//Q 10. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call

//val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]

//Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
//and get the return value as a Scala buffer. (Why this obscure class? It’s hard
//to find uses of java.util.List in the standard Java library.)

import java.awt.datatransfer._
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.mutable.Buffer
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]


val buf: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
