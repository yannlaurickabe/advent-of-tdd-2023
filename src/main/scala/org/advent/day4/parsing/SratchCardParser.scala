package org.advent.day4.parsing

import org.advent.day4.ScratchCard
import org.advent.utils.FileParser

import scala.util.Success
import scala.util.Failure

trait ScratchCardParsing {
  def allCards(path: String): Seq[ScratchCard]
}

class ScratchCardParser extends FileParser with ScratchCardParsing {
  override def allCards(path: String): Seq[ScratchCard] = parseFile(path) match {
    case Success(cardsAsString) => cardsAsString.map(ScratchCard(_))
    case Failure(exception) => throw exception
  }
}

object ScratchCardParser {
  lazy val unique: ScratchCardParser = new ScratchCardParser
}
