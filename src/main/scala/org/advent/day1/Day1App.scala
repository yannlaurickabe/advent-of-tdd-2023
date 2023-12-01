package org.advent.day1

object Day1App extends App {
  val elf: Elf = Elf()
  val path = "src/main/resources/day1.txt"

  private val solution = elf.findAllCalibrationValuesFromFile(path).sum
  println(s"The solution to Day 1's part 1 puzzle is: $solution")
}
