package org.advent.day2

import org.advent.day2.game.{Game, BagContent}
import org.advent.helpers.TestBase

class ElfTest extends TestBase {
  "allPossibleGames(games)" should {
    "not return any game if none is possible" in new Setup {
      override val bagContent: BagContent = BagContent(1, 1, 1)
      override val testObj = new Elf(bagContent)

      testObj.allPossibleGames(games) shouldBe Seq.empty
    }

    "return the only possible game if the bag contains 5 cubes of each" in new Setup {
      override val bagContent: BagContent = BagContent(5, 5, 5)
      override val testObj = new Elf(bagContent)

      val expected: Seq[Game] = Seq(game2)

      testObj.allPossibleGames(games) shouldBe expected
    }

    "return the three possible game if the bag contains 12 red cubes, 13 green cubes, and 14 blue cubes" in new Setup {
      override val bagContent: BagContent = BagContent(12, 13, 14)
      override val testObj = new Elf(bagContent)

      val expected: Seq[Game] = Seq(game1, game2, game5)

      testObj.allPossibleGames(games) shouldBe expected
    }
  }

  trait Setup extends Day2TestHelper {
    def testObj: Elf
    def bagContent: BagContent
  }
}
