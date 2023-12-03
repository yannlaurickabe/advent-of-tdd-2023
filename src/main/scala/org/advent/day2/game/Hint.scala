package org.advent.day2.game

case class Hint(cubesDescriptions: Seq[CubeDescription]) {
  require(cubesDescriptions.nonEmpty && cubesDescriptions.size <= 3)
}

object Hint {
  def apply(content: String): Hint = {
    val cubeDescriptions: Seq[String] = content.split(cubeSeparator)

    new Hint(cubeDescriptions.map(CubeDescription.fromString))
  }

  private val cubeSeparator: String = ", "
}
