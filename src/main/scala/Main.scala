import scala.io.Source

import mowitnow.Parser

object Main {
  def main(args: Array[String]) {
    val lines = Source.fromResource("instructions.txt").getLines.toList

    val parser = new Parser
    val mowers = parser.parseLines(lines)

    mowers.foreach(mower => {
      mower.move()
      println(mower)
    })
  }
}
