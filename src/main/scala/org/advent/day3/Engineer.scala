package org.advent.day3

import scala.collection.mutable.{Seq => MSeq}

class Engineer(schematic: Seq[Seq[Char]]) {
  private val m = schematic.size
  private val n = schematic.head.size

  def parts: Seq[Part] = numberLocations.flatMap { numberLocation =>
    adjacentSymbol(numberLocation) match {
      case Some(symbol) =>
        val NumberLocation(i, j, size) = numberLocation
        val id = Integer.valueOf(schematic(i).slice(j, j + size).mkString(""))
        Some(Part(id, symbol, numberLocation))
      case None => None
    }
  }

  // TODO: Use a more functional approach
  private def numberLocations: Seq[NumberLocation] = {
    var i = 0
    var locations: MSeq[NumberLocation] = MSeq.empty
    while (i < m) {
      var j = 0
      var currentNumber = ""
      while (j < n) {
        val currentChar = schematic(i)(j)
        if (isDigit(currentChar)) {
          currentNumber += currentChar.toString
        } else {
          val size = currentNumber.length
          if (size > 0) {
            locations = locations :+ NumberLocation(i, j - size, size)
            currentNumber = ""
          }
        }
        j += 1
      }
      val size = currentNumber.length
      if (size > 0) {
        locations = locations :+ NumberLocation(i, j - size, size)
        currentNumber = ""
      }
      i += 1
    }

    locations.toSeq
  }

  private def adjacentSymbol(numberLocation: NumberLocation): Option[Char] = {
    def adjacentSymbol(i: Int, j: Int): Option[Char] =
      (horizontallyAdjacent(i, j), verticallyAdjacent(i, j), diagonallyAdjacent(i, j)) match {
        case (Some(symbol), _, _) => Some(symbol)
        case (_, Some(symbol), _) => Some(symbol)
        case (_, _, Some(symbol)) => Some(symbol)
        case _ => None
      }

    val NumberLocation(i, numberStart, size) = numberLocation
    (numberStart until numberStart + size).collectFirst {
      case j if adjacentSymbol(i, j).isDefined => adjacentSymbol(i, j)
    }.flatten
  }

  private def horizontallyAdjacent(i: Int, j: Int): Option[Char] = {
    def leftSymbol(i: Int, j: Int): Option[Char] = if (j > 0 && j <= n - 1) isSymbol(i, j - 1) else None
    def rightSymbol(i: Int, j: Int): Option[Char] = if (j >= 0 && j < n - 1) isSymbol(i, j + 1) else None

    (leftSymbol(i, j), rightSymbol(i, j)) match {
      case (Some(leftChar), _) => Some(leftChar)
      case (_, Some(rightChar)) => Some(rightChar)
      case _ => None
    }
  }

  private def verticallyAdjacent(i: Int, j: Int): Option[Char] = {
    def aboveSymbol(i: Int, j: Int): Option[Char] = if (i > 0 && i <= m - 1) isSymbol(i - 1, j) else None
    def belowSymbol(i: Int, j: Int): Option[Char] = if (i >= 0 && i < m - 1) isSymbol(i + 1, j) else None

    (aboveSymbol(i, j), belowSymbol(i, j)) match {
      case (Some(aboveChar), _) => Some(aboveChar)
      case (_, Some(belowChar)) => Some(belowChar)
      case _ => None
    }
  }

  // TODO: implement
  private def diagonallyAdjacent(i: Int, j: Int): Option[Char] = {
    def aboveLeftSymbol(i: Int, j: Int): Option[Char] = if (i > 0 && j > 0) isSymbol(i - 1, j - 1) else None
    def aboveRightSymbol(i: Int, j: Int): Option[Char] = if (i > 0 && j < n - 1) isSymbol(i - 1, j + 1) else None
    def belowLeftSymbol(i: Int, j: Int): Option[Char] = if (i < m - 1 && j > 0) isSymbol(i + 1, j - 1) else None
    def belowRightSymbol(i: Int, j: Int): Option[Char] = if (i < m - 1 && j < n - 1) isSymbol(i + 1, j + 1) else None

    (aboveLeftSymbol(i, j), aboveRightSymbol(i, j), belowLeftSymbol(i, j), belowRightSymbol(i, j)) match {
      case (Some(aboveLeftChar), _, _, _) => Some(aboveLeftChar)
      case (_, Some(aboveRightChar), _, _) => Some(aboveRightChar)
      case (_, _, Some(belowLeftChar), _) => Some(belowLeftChar)
      case (_, _, _, Some(belowRightChar)) => Some(belowRightChar)
      case _ => None
    }
  }

  // TODO: Extract below methods to a util and test separately
  private def isDigit(char: Char): Boolean = Character.isDigit(char)
  private def isSymbol(i: Int, j: Int): Option[Char] = {
    val character = schematic(i)(j)
    isSymbol(character)
  }
  private def isSymbol(char: Char): Option[Char] =
    if (!Character.isLetterOrDigit(char) && char != '.') Some(char)
    else None
}

final case class Part(id: Int, symbol: Char, location: NumberLocation)
final case class NumberLocation(i: Int, j: Int, size: Int)
