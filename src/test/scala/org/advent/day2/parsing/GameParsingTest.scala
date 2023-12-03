package org.advent.day2.parsing

import org.advent.day2.game.CubeDescription._
import org.advent.day2.game.{Game, Hint, UnexpectedFormatException}
import org.advent.helpers.{TestBase, TestHelper}

class GameParsingTest extends TestBase {
  "allGames" should {
    "throw an exception if the file is not found" in new Setup {
      override val path: String = "randomPath"
      an[Exception] shouldBe thrownBy(testObj.allGames(path))
    }

    "throw an exception if a game contains an unexpected colour" in new Setup {
      override def path: String = s"$prefixPath/unexpectedColour.txt"
      an[UnexpectedFormatException] shouldBe thrownBy(testObj.allGames(path))
    }

    "throw an exception if there are more than 3 cube categories revealed" in new Setup {
      override def path: String = s"$prefixPath/tooMuchCubesCategories.txt"

      an[IllegalArgumentException] shouldBe thrownBy(testObj.allGames(path))
    }

    "throw an exception if a game is missing a content" in new Setup {
      override def path: String = s"$prefixPath/missingGameContent.txt"
      an[UnexpectedFormatException] shouldBe thrownBy(testObj.allGames(path))
    }

    "recognize a game with a single regular hint" in new Setup {
      override def path: String = s"$prefixPath/singleSimpleGame.txt"
      val expected: Seq[Game] = Seq(Game(1, Seq(Hint(Seq(Red(4), Green(2), Blue(3))))))

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with a single complex hint" in new Setup {
      override def path: String = s"$prefixPath/singleComplexGame.txt"
      val expected: Seq[Game] = Seq(Game(1, Seq(Hint(Seq(Blue(1), Green(2))))))

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with multiple simple hints" in new Setup {
      override def path: String = s"$prefixPath/simpleGame.txt"
      val expected: Seq[Game] = Seq(
        Game(1, Seq(
          Hint(Seq(Red(4), Green(2), Blue(3))),
          Hint(Seq(Red(1), Green(2), Blue(6))),
          Hint(Seq(Red(6), Green(2), Blue(1)))
        ))
      )

      testObj.allGames(path) shouldBe expected
    }

    "recognize a game with multiple complex hints" in new Setup {
      override def path: String = s"$prefixPath/complexGame.txt"

      val expected: Seq[Game] = Seq(
        Game(1, Seq(
          Hint(Seq(Blue(1), Green(2))),
          Hint(Seq(Green(3), Blue(4), Red(1))),
          Hint(Seq(Green(1), Blue(1))),
          Hint(Seq(Green(8), Blue(6)))
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
        Hint(Seq(Blue(3), Red(4))),
        Hint(Seq(Red(1), Green(2), Blue(6))),
        Hint(Seq(Green(2)))
        )
      ),
      Game(2, Seq(
        Hint(Seq(Blue(1), Green(2))),
        Hint(Seq(Green(3), Blue(4), Red(1))),
        Hint(Seq(Green(1), Blue(1))),
        )
      ),
      Game(3, Seq(
        Hint(Seq(Green(8), Blue(6), Red(20))),
        Hint(Seq(Blue(5), Red(4), Green(13))),
        Hint(Seq(Green(5), Red(1)))
        )
      ),
      Game(4, Seq(
        Hint(Seq(Green(1), Red(3), Blue(6))),
        Hint(Seq(Green(3), Red(6))),
        Hint(Seq(Green(3), Blue(15), Red(14)))
        )
      ),
      Game(5, Seq(
        Hint(Seq(Red(6), Blue(1), Green(3))),
        Hint(Seq(Blue(2), Red(1), Green(2)))
        )
      )
    )
  }
}
