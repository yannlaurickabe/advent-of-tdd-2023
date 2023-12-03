package org.advent.day2.game

case class BagContent(reds: Int, greens: Int, blues: Int) {
  require(reds > 0 && greens > 0 && blues > 0 )
}
