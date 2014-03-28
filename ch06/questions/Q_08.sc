//8. Write an enumeration describing the eight corners of the RGB color cube. As
//IDs, use the color values (for example, 0xff0000 for Red).

object RGBColorCubeCorner extends Enumeration {
    val Black = Value(Integer.parseInt("000000", 16))
    val Blue = Value(Integer.parseInt("0000FF", 16))
    val Green = Value(Integer.parseInt("00FF00", 16))
    val Turquoise = Value(Integer.parseInt("00FFFF", 16))
    val Red = Value(Integer.parseInt("FF0000", 16))
    val Mauve = Value(Integer.parseInt("FF00FF", 16))
    val Yellow = Value(Integer.parseInt("FFFF00", 16))
    val White = Value(Integer.parseInt("FFFFFF", 16))
}

for (s <- RGBColorCubeCorner.values) println(s"$s ${s.id}")