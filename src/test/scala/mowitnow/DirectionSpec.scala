package mowitnow

import org.scalatest._

class DirectionSpec extends FlatSpec with Matchers {

  // Pivot to right specs

  "North" should "be East when pivoting to right" in {
    Direction.North.pivotRight should be(Direction.East)
  }

  "East" should "be South when pivoting to right" in {
    Direction.East.pivotRight should be(Direction.South)
  }

  "South" should "be West when pivoting to right" in {
    Direction.South.pivotRight should be(Direction.West)
  }

  "West" should "be North when pivoting to right" in {
    Direction.West.pivotRight should be(Direction.North)
  }

  // Pivot to left specs

  "North" should "be West when pivoting to left" in {
    Direction.North.pivotLeft should be(Direction.West)
  }

  "West" should "be South when pivoting to left" in {
    Direction.West.pivotLeft should be(Direction.South)
  }

  "South" should "be East when pivoting to left" in {
    Direction.South.pivotLeft should be(Direction.East)
  }

  "East" should "be North when pivoting to left" in {
    Direction.East.pivotLeft should be(Direction.North)
  }
}
