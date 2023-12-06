package org.advent.day4.parsing

import org.advent.day4.{Day4TestHelper, ScratchCard}
import org.advent.helpers.TestBase

class ScratchCardParserTest extends TestBase {
  "allCards(path)" should {
    "throw an exception if the file is not found" in new Setup {
      override def path: String = s"randomPath"

      an [Exception] shouldBe thrownBy(testObj.allCards(path))
    }

    "throw an exception when there are no numbers on the card" in new Setup {
      override def path: String = s"$prefixPath/noNumbers.txt"

      an[Exception] shouldBe thrownBy(testObj.allCards(path))
    }

    "throw an exception when there is only one numbers section on the card" in new Setup {
      override def path: String = s"$prefixPath/oneNumbersSection.txt"

      an[Exception] shouldBe thrownBy(testObj.allCards(path))
    }

    "recognize a scratchcard when the file contains only one and it's simple" in new Setup {
      override def path: String = s"$prefixPath/oneSimpleScratchCard.txt"

      testObj.allCards(path) should contain theSameElementsAs Seq(singleScratchCard)
    }

    "recognize a scratchcard when the file contains only one and it's complex" in new Setup {
      override def path: String = s"$prefixPath/oneComplexScratchCard.txt"

      testObj.allCards(path) should contain theSameElementsAs Seq(singleScratchCard)
    }

    """recognize a scratchcard when the file contains multiple scratchcards
      | with single spaces next to numbers""".stripMargin in new Setup {
      override def path: String = s"$prefixPath/multipleSimpleScratchCards.txt"

      testObj.allCards(path) should contain theSameElementsAs scratchCards
    }

    """recognize a scratchcard when the file contains multiple scratchcards
      | with multiple spaces next to numbers""".stripMargin in new Setup {
      override def path: String = s"$prefixPath/multipleComplexScratchCards.txt"

      testObj.allCards(path) should contain theSameElementsAs scratchCards
    }
  }

  trait Setup extends Day4TestHelper {
    val testObj: ScratchCardParsing = new ScratchCardParser
    val prefixPath: String = s"$resourcesPath/day4"
    def path: String
  }
}
