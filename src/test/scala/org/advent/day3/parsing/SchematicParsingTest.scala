package org.advent.day3.parsing

import org.advent.helpers.TestBase
import org.advent.day3.Day3TestHelper

class SchematicParsingTest extends TestBase {
  "schematic(path)" should {
    "throw an exception when path doesn't exist" in new Setup {
      override val path: String = s"$prefixPath/random.txt"

      a[Throwable] shouldBe thrownBy(testObj.schematic(path))
    }

    "throw an Illegal Argument Exception when path points to an empty file" in new Setup {
      override val path: String = s"$prefixPath/empty.txt"

      an[IllegalArgumentException] shouldBe thrownBy(testObj.schematic(path))
    }

    "return an accurate 2d schematic when path points to a schematic file with only one line" in new Setup {
      override val path: String = s"$prefixPath/oneLine.txt"

      testObj.schematic(path) shouldBe oneLine2dSchematic
    }

    "return an accurate 2d schematic when path points to a schematic file with multiple lines" in new Setup {
      override val path: String = s"$prefixPath/multipleLines.txt"

      testObj.schematic(path) shouldBe multipleLines2dSchematic
    }
  }

  trait Setup extends Day3TestHelper {
    val testObj: SchematicParsing = new SchematicParser
    val prefixPath: String = s"$resourcesPath/day3"

    def path: String
  }
}
