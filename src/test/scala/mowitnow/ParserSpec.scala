package mowitnow

import scala.collection.mutable.ListBuffer

import org.scalatest._

class ParserSpec extends FlatSpec with Matchers with BeforeAndAfter {
  val buffer = new ListBuffer[String]
  val parser = new Parser

  after {
    buffer.clear()
  }

  "Lawn and Mowers" should "be correctly parsed when valid instructions are given" in {
    buffer.append("5 5") // first line is lawn size
    buffer.append("1 2 N") // second line is mower's initial position
    buffer.append("GAGAGAGAA") // third line contains mower's instructions

    val mowers = parser parseInstructions buffer.toList
    mowers.size should be(1)

    val mower = mowers.head
    mower shouldBe a[Mower]
    mower.position.x should be(1)
    mower.position.y should be(2)
    mower.direction should be(Direction.North)
    mower.commands.size should be(9)
    mower.lawn should be(Lawn(5, 5))
  }

  // not valid instructions specs

  "Parser" should "throw an error when not enough instructions are given" in {
    buffer.append("5 5") // just the lawn size is given
    an[AssertionError] should be thrownBy (parser parseInstructions buffer.toList)
  }

  "Parser" should "throw an error when incorrect lawn size is given" in {
    buffer.append("-5 eight") // error here
    buffer.append("1 2 N")
    buffer.append("GAGAGAGAA")

    an[IllegalArgumentException] should be thrownBy (parser parseInstructions buffer.toList)
  }

  "Parser" should "throw an error when incorrect mowers infos are given" in {
    buffer.append("5 5")
    buffer.append("1 three East") // error here
    buffer.append("GAGAGAGAA")

    an[IllegalArgumentException] should be thrownBy (parser parseInstructions buffer.toList)
  }
}
