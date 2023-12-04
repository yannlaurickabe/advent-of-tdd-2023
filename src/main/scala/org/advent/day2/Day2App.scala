package org.advent.day2

import org.advent.day2.game.CubesSet
import org.advent.day2.parsing.GameParser

object Day2App extends App {
  val path = "src/main/resources/day2.txt"
  val elf: Elf = new Elf(CubesSet(12, 13, 14))

  private val games = GameParser.unique.allGames(path)

  private val solutionPart1 = elf.allPossibleGames(games).map(_.id).sum
  println(s"The solution to Day 2's part 1 puzzle is: $solutionPart1")

  private val solutionPart2 = elf.minimumCubesSets(games).map(_.power).sum
  println(s"The solution to Day 2's part 2 puzzle is: $solutionPart2")
}
