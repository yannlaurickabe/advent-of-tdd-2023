package org.advent.day2

import org.advent.day2.game.CubeDescription._
import org.advent.day2.game.{Game, Hint}
import org.advent.helpers.TestHelper

trait Day2TestHelper extends TestHelper {
  val game1: Game = Game(1, Seq(
    Hint(Seq(Blue(3), Red(4))),
    Hint(Seq(Red(1), Green(2), Blue(6))),
    Hint(Seq(Green(2)))
   )
  )

  val game2: Game = Game(2, Seq(
    Hint(Seq(Blue(1), Green(2))),
    Hint(Seq(Green(3), Blue(4), Red(1))),
    Hint(Seq(Green(1), Blue(1))),
    )
  )

  val game3: Game = Game(3, Seq(
    Hint(Seq(Green(8), Blue(6), Red(20))),
    Hint(Seq(Blue(5), Red(4), Green(13))),
    Hint(Seq(Green(5), Red(1)))
    )
  )
  val game4: Game = Game(4, Seq(
    Hint(Seq(Green(1), Red(3), Blue(6))),
    Hint(Seq(Green(3), Red(6))),
    Hint(Seq(Green(3), Blue(15), Red(14)))
    )
  )
  val game5: Game = Game(5, Seq(
    Hint(Seq(Red(6), Blue(1), Green(3))),
    Hint(Seq(Blue(2), Red(1), Green(2)))
    )
  )

  val games: Seq[Game] = Seq(game1, game2, game3, game4, game5)
}
