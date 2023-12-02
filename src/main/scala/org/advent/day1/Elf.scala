package org.advent.day1

import scala.util.{Failure, Success}
import org.advent.utils.{FileParser, FileParsing}

class Elf(fileParser: FileParsing) {
  import Elf._
  def findAllCalibrationValuesFromFile(path: String): Seq[Int] =
    fileParser.parseFile(path) match {
      case Success(lines) =>
        if (lines.isEmpty)
          throw new IllegalArgumentException("The file is empty.")
        else lines.map(findCalibrationValueFromLine)
      case Failure(exception) => throw exception
    }

  def findCalibrationValueFromLine(line: String): Int = {
    val digits = allDigits(line).filter(_.isDigit)
    if (digits.isEmpty)
      throw new IllegalArgumentException("The line doesn't contain any digit.")
    else {
      val firstDigit = digits.head
      val lastDigit = digits.last
      Integer.valueOf(s"$firstDigit$lastDigit")
    }
  }

  private def allDigits(line: String): String = {
    var processedLine = line
    spelledOutDigits.foreach { spelledOutDigit =>
      processedLine = processedLine.replace(spelledOutDigit, fromLetterToDigit(spelledOutDigit))
    }
    processedLine
  }
}

object Elf {
  def apply() = new Elf(FileParser)

  private def fromLetterToDigit(s: String): String = s match {
    case "one" => "o1e"
    case "two" => "t2w"
    case "three" => "t3t"
    case "four" => "f4r"
    case "five" => "f5r"
    case "six" => "s6x"
    case "seven" => "s7n"
    case "eight" => "e8t"
    case "nine" => "n9e"
    case other => other
  }

  private val spelledOutDigits: Seq[String] = Seq(
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
  )
}
