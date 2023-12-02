package org.advent.day2

import org.advent.helpers.{TestBase, TestHelper}

class GameParsingTest extends TestBase {
  "allGames" should {
    "throw an exception if the file is not found" in new Setup {
      override val path: String = "randomPath"
      an[Exception] shouldBe thrownBy(testObj.allGames(path))
    }

    "throw an exception if a game contains an unexpected colour" in new Setup {
      override def path: String = s"$prefixPath/unexpextedColour.txt"
      an[UnexpectedFormatException] shouldBe thrownBy(testObj.allGames(path))
    }

    "throw an exception if a game is missing a content" in new Setup {
      override def path: String = s"$prefixPath/missingGameContent.txt"
      an[UnexpectedFormatException] shouldBe thrownBy(testObj.allGames(path))
    }

    "recognize a game with a single regular hint" in new Setup {
      override def path: String = s"$prefixPath/singleSimpleGame.txt"
      val expected: Seq[Game] = Seq(Game(1, Seq(HandfulOfCubes(4, 2, 3))))

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with a single complex hint" in new Setup {
      override def path: String = s"$prefixPath/singleComplexGame.txt"
      val expected: Seq[Game] = Seq(Game(1, Seq(HandfulOfCubes(1, 2))))

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with multiple simple hints" in new Setup {
      override def path: String = s"$prefixPath/simpleGame.txt"
      val expected: Seq[Game] = Seq(
        Game(1, Seq(
          HandfulOfCubes(4, 2, 3),
          HandfulOfCubes(1, 2, 6),
          HandfulOfCubes(6, 2, 1)
        ))
      )

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with multiple complex hints" in new Setup {
      override def path: String = s"$prefixPath/complexGame.txt"

      val expected: Seq[Game] = Seq(
        Game(1, Seq(
          HandfulOfCubes(0, 2, 1),
          HandfulOfCubes(1, 3, 4),
          HandfulOfCubes(0, 1, 1),
          HandfulOfCubes(0, 8, 6)
        ))
      )

      testObj.allGames(path) shouldBe expected
    }

    "recognize a series of games with multiple hints" in new ComplexGamesSetup {
      testObj.allGames(path) shouldBe expected
    }
  }

  trait Setup extends TestHelper {
    val testObj: GameParsing = new GameParser
    val prefixPath: String = s"$resourcesPath/day2"
    def path: String
  }

  trait ComplexGamesSetup extends Setup {
    override def path: String = s"$prefixPath/games.txt"

    val expected: Seq[Game] = Seq(
      Game(1, Seq(
        HandfulOfCubes(4, 0, 3),
        HandfulOfCubes(1, 2, 6),
        HandfulOfCubes(0, 2, 0)
        )
      ),
      Game(2, Seq(
        HandfulOfCubes(0, 2, 1),
        HandfulOfCubes(1, 3, 4),
        HandfulOfCubes(0, 1, 1),
      )
      ),
      Game(3, Seq(
        HandfulOfCubes(20, 8, 6),
        HandfulOfCubes(4, 13, 5),
        HandfulOfCubes(1, 5, 0)
      )
      ),
      Game(4, Seq(
        HandfulOfCubes(3, 1, 6),
        HandfulOfCubes(6, 3, 0),
        HandfulOfCubes(14, 3, 15)
      )
      ),
      Game(5, Seq(
        HandfulOfCubes(6, 3, 1),
        HandfulOfCubes(1, 2, 2)
      )
      )
    )
  }
}
