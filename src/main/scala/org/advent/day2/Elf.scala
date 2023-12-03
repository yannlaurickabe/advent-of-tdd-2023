package org.advent.day2

import org.advent.day2.game.{BagContent, Game}

class Elf(bagContent: BagContent) {
  def allPossibleGames(games: Seq[Game]): Seq[Game] = games.filter(_.isPossible(bagContent))
}
