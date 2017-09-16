package mowitnow

import scala.collection.mutable

class Parser {
  def parseLines(lines: List[String]): mutable.MutableList[Mower] = {
    // First line is the size of the lawn
    val (lawnSize, mowersInstructions) = lines.splitAt(1)

    // Other following lines (by group of 2) contains each mower informations
    val mowersInfos = mowersInstructions.grouped(2).toList

    val lawn = parseLawnSizes(lawnSize.head.mkString)

    val mowers = mutable.MutableList[Mower]()
    mowersInfos.foreach(mowerInfos => {
      val (x, y, d) = parseMowerInfos(mowerInfos.head.mkString)
      val mower = new Mower(x, y, d, lawn)

      mower.addCommands(mowerInfos.tail.mkString)
      mowers += mower
    })

    mowers
  }

  private def parseLawnSizes(lawnSize: String): Lawn = {
    val SizePattern = "([0-9]+) ([0-9]+)".r
    lawnSize match {
      case SizePattern(height, width) => Lawn(height.toInt, width.toInt)
      case _ =>
        throw new IllegalArgumentException(
          "Size of Lawn doesn't match the expected format : ([0-9]+) ([0-9]+)")
    }
  }

  private def parseMowerInfos(infos: String): (Int, Int, Char) = {
    val infosPattern = "([0-9]+) ([0-9]+) ([NWES])".r
    infos match {
      case infosPattern(x, y, d) => (x.toInt, y.toInt, d.charAt(0))
      case _ =>
        throw new IllegalArgumentException(
          "Mower informations don't match the expected format: ([0-9]+) ([0-9]+) ([NWES])")
    }
  }
}
