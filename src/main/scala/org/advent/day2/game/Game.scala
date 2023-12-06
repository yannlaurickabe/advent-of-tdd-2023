package org.advent.day2.game

import scala.util.matching.Regex
import scala.math.max
import org.advent.utils.nonNullIntegerPattern

case class Game(id: Int, revealedCubes: Seq[Hint]) {
  def isPossible(bagContent: CubesSet): Boolean = revealedCubes.forall(_.isPossible(bagContent))

  def minimumCubesSet: CubesSet = revealedCubes.map(_.perfectCubesSetMatch).reduce {
    (cs1, cs2) =>
      val minRed = max(cs1.reds, cs2.reds)
      val minGreen = max(cs1.greens, cs2.greens)
      val minBlue = max(cs1.blues, cs2.blues)
      CubesSet(minRed, minGreen, minBlue)
  }
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
