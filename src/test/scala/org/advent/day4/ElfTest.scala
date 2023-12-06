package org.advent.day4

import org.advent.helpers.TestBase

class ElfTest extends TestBase {
  "points" should {
    "sum correctly the values of all the elf's scratchcards" in new Setup {
      testObj.points shouldBe 13
    }

    trait Setup extends Day4TestHelper {
      val testObj: Elf = new Elf(scratchCards)
    }
  }
}
