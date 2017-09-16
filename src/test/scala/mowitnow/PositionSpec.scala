package mowitnow

import org.scalatest._

class PositionSpec extends FlatSpec with Matchers {
  "A Position" should "be upper when moving to North" in {
    Position(1, 1) change Direction.North should be(Position(1, 2))
  }

  "A Position" should "be lower when moving to South" in {
    Position(2, 2) change Direction.South should be(Position(2, 1))
  }

  "A Position" should "be more right when moving to East" in {
    Position(1, 1) change Direction.East should be(Position(2, 1))
  }

  "A Position" should "be more left when moving to West" in {
    Position(1, 1) change Direction.West should be(Position(0, 1))
  }

  "A Position" should "throw an error when unknown Direction is provided" in {
    an[IllegalArgumentException] should be thrownBy (Position(1, 1) change null)
  }
}
