package org.advent.day2.game

import scala.util.matching.Regex
import org.advent.utils.nonNullIntegerPattern

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
    case _ => throw UnexpectedCubeDescriptionFormatException("Unexpected colour")
  }

  private val redPattern: Regex = s"""($nonNullIntegerPattern) red""".r
  private val greenPattern: Regex = s"""($nonNullIntegerPattern) green""".r
  private val bluePattern: Regex = s"""($nonNullIntegerPattern) blue""".r
}
