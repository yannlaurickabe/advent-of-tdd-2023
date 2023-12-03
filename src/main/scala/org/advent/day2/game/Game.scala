package org.advent.day2.game

import scala.util.matching.Regex

case class Game(id: Int, revealedCubes: Seq[Hint])

object Game {
  def apply(gameAsString: String): Game = gameAsString match {
    case gamePattern(idAsString, hintsAsString) =>
      val id = Integer.valueOf(idAsString)
      val revealedCubes = hintsAsString.split(hintSeparator).map(Hint(_))

      Game(id, revealedCubes)
    case _ => throw UnexpectedFormatException()
  }

  private val gamePattern: Regex = """Game ([1-9]+): (.*)""".r
  private val hintSeparator: String = "; "
}
