package org.advent.day3

import org.advent.day3.parsing.SchematicParser

object Day3App extends App {

  val path = "src/main/resources/day3.txt"
  val schematic: Seq[Seq[Char]] = SchematicParser.unique.schematic(path)
  val engineer: Engineer = new Engineer(schematic)

  val solution: Int = engineer.parts.map(_.id).sum
  println(s"The solution to Day 3's part 1 puzzle is: $solution")
}
