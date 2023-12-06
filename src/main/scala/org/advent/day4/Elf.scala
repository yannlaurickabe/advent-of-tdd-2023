package org.advent.day4

class Elf(scratchCards: Seq[ScratchCard]) {
  def points: Int = scratchCards.map(_.value).sum
}
