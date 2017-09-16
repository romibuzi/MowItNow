package mowitnow

import org.scalatest._

class MowerSpec extends FlatSpec with Matchers {
  "A Mower" should "be at the same initial position if no actions were given" in {
    val lawn = Lawn(5, 5)
    val mower = new Mower(1, 2, 'N', lawn)
    mower.move()

    mower.direction should be(Direction.North)
    mower.position should be(Position(1, 2))
  }

  "A Mower" should "throw an error when unvalid command is given" in {
    val lawn = Lawn(5, 5)
    val mower = new Mower(1, 2, 'N', lawn)
    an[IllegalArgumentException] should be thrownBy (mower addCommand 'R')
  }

  "A Mower" should "be in the correct final position given its initial position and its actions received" in {
    val lawn = Lawn(5, 5)
    val mower = new Mower(1, 2, 'N', lawn)
    mower.addCommands("GAGAGAGAA")
    mower.move()

    mower.direction should be(Direction.North)
    mower.position should be(Position(1, 3))
  }
}
