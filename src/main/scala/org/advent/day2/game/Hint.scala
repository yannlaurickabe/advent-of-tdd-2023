package org.advent.day2.game

import org.advent.day2.game.CubeDescription._

case class Hint(cubesDescriptions: Seq[CubeDescription]) {
  require(cubesDescriptions.nonEmpty && cubesDescriptions.size <= 3)

  def isPossible(bagContent: CubesSet): Boolean =
    cubesDescriptions.map {
      case Red(quantity) => quantity <= bagContent.reds
      case Green(quantity) => quantity <= bagContent.greens
      case Blue(quantity) => quantity <= bagContent.blues
    }.reduce(_ && _)

  def perfectCubesSetMatch: CubesSet = {
    val redDescriptions = cubesDescriptions.collect { case Red(quantity) => quantity }
    val perfectRedMatch = if (redDescriptions.nonEmpty) redDescriptions.max else 0
    val greenDescriptions = cubesDescriptions.collect { case Green(quantity) => quantity }
    val perfectGreenMatch = if (greenDescriptions.nonEmpty) greenDescriptions.max else 0
    val blueDescriptions = cubesDescriptions.collect { case Blue(quantity) => quantity }
    val perfectBlueMatch = if (blueDescriptions.nonEmpty) blueDescriptions.max else 0

  CubesSet(perfectRedMatch, perfectGreenMatch, perfectBlueMatch)
  }
}

object Hint {
  def apply(content: String): Hint = {
    val cubeDescriptions: Seq[String] = content.split(cubeSeparator)

    new Hint(cubeDescriptions.map(CubeDescription.fromString))
  }

  private val cubeSeparator: String = ", "
}
