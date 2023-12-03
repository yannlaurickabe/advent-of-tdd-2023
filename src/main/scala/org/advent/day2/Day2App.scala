package org.advent.day2

import org.advent.day2.parsing.GameParser

object Day2App extends App {
  val path = "src/main/resources/day1.txt"
  val elf: Elf = new Elf

  private val games = GameParser.unique.allGames(path)
  private val solution = elf.allPossibleGames(games).map(_.id).sum

  println(s"The solution to Day 2's part 1 puzzle is: $solution")
}
