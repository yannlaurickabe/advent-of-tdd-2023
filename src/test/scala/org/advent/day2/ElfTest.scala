package org.advent.day2

import org.advent.day2.game.{Game, CubesSet}
import org.advent.helpers.TestBase

class ElfTest extends TestBase {
  "allPossibleGames(games)" should {
    "not return any game if none is possible" in new Setup {
      override val cubesSet: CubesSet = CubesSet(1, 1, 1)
      override val testObj = new Elf(cubesSet)

      testObj.allPossibleGames(games) shouldBe Seq.empty
    }

    "return the only possible game if the bag contains 5 cubes of each" in new Setup {
      override val cubesSet: CubesSet = CubesSet(5, 5, 5)
      override val testObj = new Elf(cubesSet)

      val expected: Seq[Game] = Seq(game2)

      testObj.allPossibleGames(games) shouldBe expected
    }

    "return the three possible game if the bag contains 12 red cubes, 13 green cubes, and 14 blue cubes" in new Setup {
      override val cubesSet: CubesSet = CubesSet(12, 13, 14)
      override val testObj = new Elf(cubesSet)

      val expected: Seq[Game] = Seq(game1, game2, game5)

      testObj.allPossibleGames(games) shouldBe expected
    }
  }

  "minimumCubesSets(games)" should {
    "return a sequence of the minimum set of cubes required to play each game" in new MinCubesSetSetup {
      val expected: Seq[CubesSet] = Seq(
        CubesSet(4, 2, 6),
        CubesSet(1, 3, 4),
        CubesSet(20, 13, 6),
        CubesSet(14, 3, 15),
        CubesSet(6, 3, 2),
      )

      testObj.minimumCubesSets(games) shouldBe expected
    }
  }

  trait Setup extends Day2TestHelper {
    def cubesSet: CubesSet
    def testObj: Elf
  }

  trait MinCubesSetSetup extends Setup {
    override val cubesSet: CubesSet = CubesSet(10, 10, 10)
    override def testObj: Elf = new Elf(cubesSet)
  }
}
