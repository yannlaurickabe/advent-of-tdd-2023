package org.advent.day4

import org.advent.day4.parsing.ScratchCardParser

object Day4App extends App {
  val path = "src/main/resources/day4.txt"
  val scratchCards: Seq[ScratchCard] = ScratchCardParser.unique.allCards(path)
  val elf: Elf = new Elf(scratchCards)

  private val solutionPart1 = elf.points
  println(s"The solution to Day 4's part 1 puzzle is: $solutionPart1")
}
