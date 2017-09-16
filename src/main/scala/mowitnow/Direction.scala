package mowitnow

case class Direction(d: Char) {
  // map of associated directions when pivoting to right
  val map: Map[Char, Char] = Map(
    'N' -> 'E',
    'W' -> 'N',
    'S' -> 'W',
    'E' -> 'S'
  )

  // swap the map before so we get direction associations when pivoting to left
  def pivotLeft = Direction(map.map(_.swap).apply(d))
  def pivotRight = Direction(map.apply(d))
}

object Direction {
  val North = Direction('N')
  val West = Direction('W')
  val South = Direction('S')
  val East = Direction('E')
}
