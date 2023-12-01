package org.advent.day1

import scala.util.{Failure, Success}
import org.advent.utils.{FileParser, FileParsing}

class Elf(fileParser: FileParsing) {
  def findAllCalibrationValuesFromFile(path: String): Seq[Int] =
    fileParser.parseFile(path) match {
      case Success(lines) =>
        if (lines.isEmpty)
          throw new IllegalArgumentException("The file is empty.")
        else lines.map(findCalibrationValueFromLine)
      case Failure(exception) => throw exception
    }

  def findCalibrationValueFromLine(line: String): Int = {
    val digits = line.filter(_.isDigit)
    if (digits.isEmpty)
      throw new IllegalArgumentException("The line doesn't contain any digit.")
    else {
      val firstDigit = digits.head
      val lastDigit = digits.last
      Integer.valueOf(s"$firstDigit$lastDigit")
    }
  }
}

object Elf {
  def apply() = new Elf(FileParser)
}
