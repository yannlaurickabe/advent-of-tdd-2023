package org.advent.day3.parsing

import scala.util.Success
import scala.util.Failure
import org.advent.utils.FileParser

trait SchematicParsing {
  def schematic(path: String): Seq[Seq[Char]]
}

class SchematicParser extends FileParser with SchematicParsing {
  override def schematic(path: String): Seq[Seq[Char]] = parseFile(path) match {
    case Success(rows) =>
      if (rows.isEmpty) throw new IllegalArgumentException("Empty schematic")
      else rows.map(_.toCharArray.toSeq)
    case Failure(exception) => throw exception
  }
}

object SchematicParser {
  lazy val unique: SchematicParser = new SchematicParser
}