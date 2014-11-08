sealed abstract class TrafficLightColour

case object Red extends TrafficLightColour
case object Yellow extends TrafficLightColour
case object Green extends TrafficLightColour

def traffic(colour: TrafficLightColour) = {
  colour match {
    case Red => "stop"
    case Yellow => "get ready"
    case Green => "go"
  }
}

traffic(Red)
traffic(Yellow)
traffic(Green)