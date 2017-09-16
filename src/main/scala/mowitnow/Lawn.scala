package mowitnow

case class Lawn(width: Int, height: Int) {
  private val base = (0, 0)

  def allowPosition(position: Position): Boolean =
    position.x <= height && position.x >= base._1 &&
      position.y <= width && position.y >= base._2
}
