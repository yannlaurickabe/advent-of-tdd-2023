package org.advent.day2.game

import org.advent.day2.game.CubeDescription._

case class Hint(cubesDescriptions: Seq[CubeDescription]) {
  require(cubesDescriptions.nonEmpty && cubesDescriptions.size <= 3)

  def isPossible(bagContent: BagContent): Boolean =
    cubesDescriptions.map {
      case Red(quantity) => quantity <= bagContent.reds
      case Green(quantity) => quantity <= bagContent.greens
      case Blue(quantity) => quantity <= bagContent.blues
    }.reduce(_ && _)
}

object Hint {
  def apply(content: String): Hint = {
    val cubeDescriptions: Seq[String] = content.split(cubeSeparator)

    new Hint(cubeDescriptions.map(CubeDescription.fromString))
  }

  private val cubeSeparator: String = ", "
}
