package org.advent.day2.game

case class CubesSet(reds: Int, greens: Int, blues: Int) {
  def power: Int = reds * greens * blues
}
