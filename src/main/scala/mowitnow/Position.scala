package mowitnow

case class Position(x: Int, y: Int) {
  def change(direction: Direction): Position = {
    direction match {
      case Direction.North => Position(x, y + 1)
      case Direction.West  => Position(x - 1, y)
      case Direction.South => Position(x, y - 1)
      case Direction.East  => Position(x + 1, y)
      case _ =>
        throw new IllegalArgumentException("Not a valid Direction given")
    }
  }
}
