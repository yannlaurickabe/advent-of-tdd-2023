package org.advent.utils

import scala.io.Source
import scala.util.{Try, Using}

trait FileParsing {
  def parseFile(path: String): Try[Seq[String]]
}

class FileParser extends FileParsing {
  override def parseFile(path: String): Try[Seq[String]] =
    Using.Manager { use =>
      val file = use(Source.fromFile(path))
      file.getLines().toSeq
    }
}

object FileParser {
  lazy val unique: FileParser = new FileParser
}
