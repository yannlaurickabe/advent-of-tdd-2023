package org.advent.day3

import org.advent.helpers.TestBase

class EngineerTest extends TestBase {

  "parts" should {
    """recognize part numbers when they are single digit and
      | horizontally adjacent to a symbol""".stripMargin in new SingleDigitHorizontal {
      override val expected: Seq[Part] = Seq(
        Part(2, '*', NumberLocation(0, 6, 1)),
        Part(7, '$', NumberLocation(1, 10, 1)),
        Part(1, '#', NumberLocation(2, 2, 1))
      )

      testObj.parts should contain theSameElementsAs expected
    }

    """recognize part numbers when they are multiple digits
      | and horizontally adjacent to a symbol""".stripMargin in new MultipleDigitsHorizontal {
      override val expected: Seq[Part] = Seq(
        Part(259, '*', NumberLocation(0, 6, 3)),
        Part(7, '$', NumberLocation(1, 10, 1)),
        Part(16, '#', NumberLocation(2, 2, 2))
      )

      testObj.parts shouldBe expected
    }

    """recognize part numbers when they are single digit
      | and vertically adjacent to a symbol""".stripMargin in new SingleDigitVertical {
      override val expected: Seq[Part] = Seq(
        Part(8, '$', NumberLocation(0, 9, 1)),
        Part(1, '#', NumberLocation(2, 2, 1)),
        Part(2, '*', NumberLocation(1, 5, 1)),
        Part(7, '$', NumberLocation(2, 9, 1))
      )

      testObj.parts shouldBe expected
    }

    """recognize part numbers when they are multiple digits
      | and vertically adjacent to a symbol""".stripMargin in new MultipleDigitsVertical {
      override val expected: Seq[Part] = Seq(
        Part(81, '#', NumberLocation(1, 0, 2)),
        Part(6291, '*', NumberLocation(1, 4, 4)),
        Part(73, '$', NumberLocation(2, 9, 2))
      )

      testObj.parts shouldBe expected
    }

    "recognize part numbers when they are single digit and diagonally adjacent to a symbol" in new SingleDigitDiagonal {
      override val expected: Seq[Part] = Seq(
        Part(5, '$', NumberLocation(0, 10, 1)),
        Part(1, '@', NumberLocation(1, 2, 1)),
        Part(3, '$', NumberLocation(2, 10, 1))
      )

      testObj.parts shouldBe expected
    }

    """recognize part numbers when they are multiple digit
      | and diagonally adjacent to a symbol""".stripMargin in new MultipleDigitsDiagonal {
      override val expected: Seq[Part] = Seq(
        Part(92, '$', NumberLocation(0, 7, 2)),
        Part(19, '@', NumberLocation(1, 2, 2)),
        Part(3, '$', NumberLocation(2, 10, 1))
      )

      testObj.parts shouldBe expected
    }

    "recognize part numbers in the general case" in new RealisticSetup {
      override val expected: Seq[Part] = Seq(
        Part(467, '*', NumberLocation(0, 0, 3)),
        Part(35, '*', NumberLocation(1, 2, 2)),
        Part(633, '#', NumberLocation(2, 6, 3)),
        Part(617, '*', NumberLocation(4, 0, 3)),
        Part(592, '+', NumberLocation(6, 2, 3)),
        Part(755, '*', NumberLocation(7, 6, 3)),
        Part(664, '$', NumberLocation(9, 1, 3)),
        Part(598, '*', NumberLocation(9, 5, 3))
      )

      testObj.parts shouldBe expected
    }
  }

  trait Setup extends Day3TestHelper {
    def schematic: Seq[Seq[Char]]
    def testObj: Engineer
    def expected: Seq[Part]
  }

  trait SingleDigitHorizontal extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', '2', dot, '9', dot, dot),
      Seq(dot, dot, dot, dot, dot, dot, dot, dot, dot, '$', '7'),
      Seq(dot, '#', '1', dot, dot, dot, dot, dot, dot, dot, dot)
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait MultipleDigitsHorizontal extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', '2', '5', '9', dot, dot),
      Seq(dot, dot, dot, dot, dot, dot, dot, dot, dot, '$', '7'),
      Seq(dot, '#', '1', '6', dot, dot, dot, dot, dot, dot, dot)
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait SingleDigitVertical extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', dot, '9', dot, '8', dot),
      Seq(dot, '1', dot, dot, dot, '2', dot, dot, dot, '$', dot),
      Seq(dot, '#', dot, dot, dot, dot, dot, dot, dot, '7', dot)
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait MultipleDigitsVertical extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', dot, '9', dot, dot, dot),
      Seq('8', '1', dot, dot, '6', '2', '9', '1', dot, '$', dot),
      Seq(dot, '#', dot, dot, dot, dot, dot, dot, dot, '7', '3')
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait SingleDigitDiagonal extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', dot, '9', dot, dot, '5'),
      Seq(dot, dot, '1', dot, dot, dot, dot, dot, dot, '$', dot),
      Seq(dot, '@', dot, dot, dot, dot, dot, dot, dot, dot, '3')
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait MultipleDigitsDiagonal extends Setup {
    override val schematic: Seq[Seq[Char]] = Seq(
      Seq('4', dot, '6', dot, dot, '*', dot, '9', '2', dot, dot),
      Seq(dot, dot, '1', '9', dot, dot, dot, dot, dot, '$', dot),
      Seq(dot, '@', dot, dot, dot, dot, dot, dot, dot, dot, '3')
    )

    override val testObj: Engineer = new Engineer(schematic)
  }

  trait RealisticSetup extends Setup {
    override val schematic: Seq[Seq[Char]] = multipleLines2dSchematic
    override val testObj: Engineer = new Engineer(schematic)
  }
}
