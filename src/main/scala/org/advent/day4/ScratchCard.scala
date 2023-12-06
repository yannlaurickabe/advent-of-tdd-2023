package org.advent.day4

import scala.math.pow
import scala.util.matching.Regex

case class ScratchCard(id: Int, winningNumbers: Seq[Int], cardNumbers: Seq[Int]) {
  def value: Int = pow(2, winningNumbers.intersect(cardNumbers).size - 1).toInt
}

object ScratchCard {
  def apply(cardsAsString: String): ScratchCard = cardsAsString match {
    case scratchCardPattern(idAsString, numbersAsString) =>
      val id = Integer.valueOf(idAsString)
      val numbersSectionSeparatorIndex = numbersAsString.indexOf(numbersSectionSeparator)

      val winningNumbersAsString: String = numbersAsString.slice(1, numbersSectionSeparatorIndex)
      val cardNumbersAsString: String = numbersAsString.slice(numbersSectionSeparatorIndex + 1, numbersAsString.length)

      val winningNumbers = winningNumbersAsString.trim.split(numbersSeparator).map(_.strip().toInt)
      val cardNumbers = cardNumbersAsString.trim.split(numbersSeparator).map(_.strip().toInt)

      ScratchCard(id, winningNumbers, cardNumbers)
    case _ => throw new IllegalArgumentException
  }

  private val scratchCardPattern: Regex = """Card\s+([1-9][0-9]*):(.*)$""".r
  private val numbersSectionSeparator: String = """|"""
  private val numbersSeparator: String = """\s+"""
}
