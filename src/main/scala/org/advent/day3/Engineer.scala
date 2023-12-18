package org.advent.day3

class Engineer(schematic: Seq[Seq[Char]]) {
  def parts: Seq[Part] = ???
}

case class Part(id: Int, symbol: Char, location: PartNumberLocation)
case class PartNumberLocation(i: Int, j: Int, size: Int)