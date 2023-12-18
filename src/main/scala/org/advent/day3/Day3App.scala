package org.advent.day3

import org.advent.day3.parsing.SchematicParser

object Day3App extends App {

  val path = "src/main/resources/day3.txt"

  // from file to 2D schematic: SchematicParser
  val schematic: Seq[Seq[Char]] = SchematicParser.unique.schematic(path)

  // from 2D schematic to parts: Engineer
  // sum of all parts' numbers
  ???
}
