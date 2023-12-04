package org.advent.day2

import org.advent.day2.game.{CubesSet, Game}

class Elf(bagContent: CubesSet) {
  def allPossibleGames(games: Seq[Game]): Seq[Game] = games.filter(_.isPossible(bagContent))
  def minimumCubesSets(games: Seq[Game]): Seq[CubesSet] = games.map(_.minimumCubesSet)
}
