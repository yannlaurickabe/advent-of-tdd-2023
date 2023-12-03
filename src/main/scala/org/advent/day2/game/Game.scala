package org.advent.day2.game

import scala.util.matching.Regex

case class Game(id: Int, revealedCubes: Seq[Hint]) {
  def isPossible(bagContent: BagContent): Boolean = revealedCubes.forall(_.isPossible(bagContent))
}

object Game {
  def apply(gameAsString: String): Game = gameAsString match {
    case gamePattern(idAsString, hintsAsString) =>
      val id = Integer.valueOf(idAsString)
      val revealedCubes = hintsAsString.split(hintSeparator).map(Hint(_))

      Game(id, revealedCubes)
    case _ => throw UnexpectedGameFormatException()
  }

  private val gamePattern: Regex = s"""Game ($nonNullIntegerPattern): (.*)""".r
  private val hintSeparator: String = "; "
}
