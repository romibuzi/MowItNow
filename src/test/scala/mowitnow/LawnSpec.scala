package mowitnow

import org.scalatest._

class LawnSpec extends FlatSpec with Matchers {

  // not valid Position specs

  "A Lawn" should "not allow a negative Position in both X and Y" in {
    Lawn(5, 5) allowPosition Position(-1, -1) should be(false)
  }

  "A Lawn" should "not allow a negative Position in X only" in {
    Lawn(5, 5) allowPosition Position(-1, 1) should be(false)
  }

  "A Lawn" should "not allow a negative Position in Y only" in {
    Lawn(5, 5) allowPosition Position(1, -1) should be(false)
  }

  "A Lawn" should "not allow a Position greater than its width" in {
    Lawn(5, 5) allowPosition Position(6, 3) should be(false)
  }

  "A Lawn" should "not allow a Position greater than its height" in {
    Lawn(5, 5) allowPosition Position(3, 6) should be(false)
  }

  // valid Positions specs

  "A Lawn" should "allow a base Position" in {
    Lawn(5, 5) allowPosition Position(0, 0) should be(true)
  }

  "A Lawn" should "allow a Position in its surface" in {
    Lawn(5, 5) allowPosition Position(2, 3) should be(true)
  }

  "A Lawn" should "allow a Position at its max height" in {
    Lawn(5, 5) allowPosition Position(1, 5) should be(true)
  }

  "A Lawn" should "allow a Position at its max width" in {
    Lawn(5, 5) allowPosition Position(5, 1) should be(true)
  }

  "A Lawn" should "allow a Position at both its max width and height" in {
    Lawn(5, 5) allowPosition Position(5, 5) should be(true)
  }
}
