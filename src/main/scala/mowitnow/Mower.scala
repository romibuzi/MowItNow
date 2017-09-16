package mowitnow

class Mower(x: Int, y: Int, dc: Char, lawnc: Lawn) {
  var position = Position(x, y)
  var direction = Direction(dc)
  var commands: List[Command] = List[Command]()
  val lawn: Lawn = lawnc

  override def toString: String =
    s"(x:${position.x}, y:${position.y}, direction:${direction.d})"

  def addCommand(command: Char): Unit = {
    command match {
      case 'G' => commands = commands :+ Left
      case 'D' => commands = commands :+ Right
      case 'A' => commands = commands :+ Forward
      case _ =>
        throw new IllegalArgumentException(
          "Not a valid command, It could only be either 'G', 'D' or 'A'")
    }
  }

  // Receive all commands at once and add them secquentially, ex: "GAGAGAGAA"
  def addCommands(commands: String): Unit =
    commands.toList.foreach(command => addCommand(command))

  def move(): Unit = {
    // Secquentially execute all commands received
    commands.foreach {
      case Left    => direction = direction.pivotLeft
      case Right   => direction = direction.pivotRight
      case Forward => forward()
    }
  }

  def forward(): Unit = {
    val newPosition = position change direction

    // Check that the new position isn't outside the lawn
    // If it's the case, the position doesn't change
    if (lawn allowPosition newPosition) {
      position = newPosition
    }
  }
}
