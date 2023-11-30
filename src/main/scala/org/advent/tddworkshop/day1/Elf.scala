package org.advent.tddworkshop.day1

/**
 * Elf that is assigned calories
 */
class Elf(private var _totalCalories: Int = 0) {

  def totalCalories: Int = _totalCalories

  def addCalories(caloriesToAdd: Int): Unit = _totalCalories += caloriesToAdd

  def compare(other: Elf): Int = Integer.compare(_totalCalories, other.totalCalories)
}
