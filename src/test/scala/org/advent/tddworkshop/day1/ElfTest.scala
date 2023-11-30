package org.advent.tddworkshop.day1

import org.utils.TestBase

class ElfTest extends TestBase {
  "an elf" should {
    "be created with zero calories" in {
      val elf: Elf = new Elf()
      elf.totalCalories shouldBe 0
    }
  }

  "addCalories(number)" should {
    "increase the number of calories of the elf by number" in {
      val elf: Elf = new Elf()
      elf.addCalories(1000)

      elf.totalCalories shouldBe 1000
    }
  }

  "compare(other)" should {
    "return 1 when other has less food than the current elf" in {
      val elf = new Elf(1000)
      val other = new Elf()

      elf.compare(other) shouldBe 1
    }

    "return 0 when other exactly the same amout of food than the current elf" in {
      val elf = new Elf(1000)
      val other = new Elf(1000)

      elf.compare(other) shouldBe 0
    }

    "return -1 when other has more food than the current elf" in {
      val elf = new Elf()
      val other = new Elf(1000)

      elf.compare(other) shouldBe -1
    }
  }
}
