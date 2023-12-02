package org.advent.day2

import org.advent.utils.FileParser

import scala.util.{Failure, Success}

trait GameParsing {
  def allGames(path: String): Seq[Game]
}
class GameParser extends FileParser with GameParsing {
  override def allGames(path: String): Seq[Game] = parseFile(path) match {
    case Success(gamesAsString) => ???
    case Failure(exception) => throw exception
  }
}

object GameParser {
  lazy val unique: GameParser = new GameParser
}
