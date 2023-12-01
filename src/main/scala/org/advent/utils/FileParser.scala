package org.advent.utils

import scala.io.Source
import scala.util.{Try, Using}

sealed trait FileParsing {
  def parseFile(path: String): Try[Seq[String]]
}

object FileParser extends FileParsing {
  def parseFile(path: String): Try[Seq[String]] =
    Using.Manager { use =>
      val file = use(Source.fromFile(path))
      file.getLines().toSeq
    }
}
