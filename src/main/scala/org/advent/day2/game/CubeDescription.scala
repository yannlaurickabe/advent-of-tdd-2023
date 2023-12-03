package org.advent.day2.game

import scala.util.matching.Regex

sealed trait CubeDescription {
  def quantity: Int
}

object CubeDescription {
  case class Red(override val quantity: Int) extends CubeDescription
  case class Green(override val quantity: Int) extends CubeDescription
  case class Blue(override val quantity: Int) extends CubeDescription

  def fromString(colour: String): CubeDescription = colour match {
    case redPattern(quantity) => Red(Integer.valueOf(quantity))
    case greenPattern(quantity) => Green(Integer.valueOf(quantity))
    case bluePattern(quantity) => Blue(Integer.valueOf(quantity))
    case _ => throw UnexpectedFormatException("Unexpected colour")
  }

  private val redPattern: Regex = """([1-9][0-9]*) red""".r
  private val greenPattern: Regex = """([1-9][0-9]*) green""".r
  private val bluePattern: Regex = """([1-9][0-9]*) blue""".r
}
