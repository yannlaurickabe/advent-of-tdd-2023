package org.advent.day4

import org.advent.helpers.TestHelper

trait Day4TestHelper extends TestHelper {
  val singleScratchCard: ScratchCard = ScratchCard(1, Seq(41, 48, 83, 86, 17), Seq(83, 86, 6, 31, 17, 9, 48, 53))

  val scratchCards: Seq[ScratchCard] = Seq(
    ScratchCard(1, Seq(41, 48, 83, 86, 17), Seq(83, 86, 6, 31, 17, 9, 48, 53)),
    ScratchCard(2, Seq(13, 32, 20, 16, 61), Seq(61, 30, 68, 82, 17, 32, 24, 19)),
    ScratchCard(3, Seq(1, 21, 53, 59, 44), Seq(69, 82, 63, 72, 16, 21, 14, 1)),
    ScratchCard(4, Seq(41, 92, 73, 84, 69), Seq(59, 84, 76, 51, 58, 5, 54, 83)),
    ScratchCard(5, Seq(87, 83, 26, 28, 32), Seq(88, 30, 70, 12, 93, 22, 82, 36)),
    ScratchCard(6, Seq(31, 18, 13, 56, 72), Seq(74, 77, 10, 23, 35, 67, 36, 11))
  )
}
