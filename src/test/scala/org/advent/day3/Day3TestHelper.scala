package org.advent.day3

import org.advent.helpers.TestHelper

trait Day3TestHelper extends TestHelper {
  private val dot: Char = '.'
  private val line1: Seq[Char] = Seq('4', '6', '7', dot, dot, '1', '1', '4', dot, dot)
  private val line2: Seq[Char] = Seq(dot, dot, dot, '*', dot, dot, dot, dot, dot, dot)
  private val line3: Seq[Char] = Seq(dot, dot, '3', '5', dot, dot, '6', '3', '3', dot)
  private val line4: Seq[Char] = Seq(dot, dot, dot, dot, dot, dot, '#', dot, dot, dot)
  private val line5: Seq[Char] = Seq('6', '1', '7', '*', dot, dot, dot, dot, dot, dot)
  private val line6: Seq[Char] = Seq(dot, dot, dot, dot, dot, '+', dot, '5', '8', dot)
  private val line7: Seq[Char] = Seq(dot, dot, '5', '9', '2', dot, dot, dot, dot, dot)
  private val line8: Seq[Char] = Seq(dot, dot, dot, dot, dot, dot, '7', '5', '5', dot)
  private val line9: Seq[Char] = Seq(dot, dot, dot, '$', dot, '*', dot, dot, dot, dot)
  private val line10: Seq[Char] = Seq(dot, '6', '6', '4', dot, '5', '9', '8', dot, dot)

  val oneLine2dSchematic: Seq[Seq[Char]] = Seq(line1)

  val multipleLines2dSchematic: Seq[Seq[Char]] = Seq(
    line1,
    line2,
    line3,
    line4,
    line5,
    line6,
    line7,
    line8,
    line9,
    line10
  )
}
