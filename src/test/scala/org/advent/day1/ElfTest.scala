package org.advent.day1

import scala.util.Success
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito.when
import org.advent.utils.FileParsing
import org.advent.helpers.{TestBase, TestHelper}
import org.mockito.ArgumentMatchers.any

import scala.collection.immutable.Seq

class ElfTest extends TestBase with MockitoSugar {

  "findCalibrationValueFromLine(line)" should {
    "throw an exception when no digit is found in line" in new SingleCalibrationValueSetup {
      override val line = "lineWithoutDigit"

      an[Exception] shouldBe thrownBy(testObj.findCalibrationValueFromLine(line))
    }

    """return a number composed of two identical digits when there is exactly one numeric digit
      | in line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "abc5dhw"

      testObj.findCalibrationValueFromLine(line) shouldBe 55
    }

    """return a number composed of two identical digits when there is exactly one spelled out digit
      | in line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "abcfivedhw"

      testObj.findCalibrationValueFromLine(line) shouldBe 55
    }

    """return a number composed of the first digit and the last digit of the line
      | when numeric digits are exactly at the start and end of line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "2abcdhw4"

      testObj.findCalibrationValueFromLine(line) shouldBe 24
    }

    """return a number composed of the first digit and the last digit of the line when spelled out digits are exactly
      | at the start and end of line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "twoabcdhwfour"

      testObj.findCalibrationValueFromLine(line) shouldBe 24
    }

    """return a number composed of the first digit and last digit of line even when numeric digits are not exactly
      | at the start or the end of line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "ab6cd7hw"

      testObj.findCalibrationValueFromLine(line) shouldBe 67
    }

    """return a number composed of the first digit and last digit of line even when spelled out digits are not exactly
      | at the start or the end of line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "absixcdsevenhw"

      testObj.findCalibrationValueFromLine(line) shouldBe 67
    }

    """return a number composed of the first digit and last digit of line even when there are other numeric digits
      | in between""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "a1bc8dh5w7"

      testObj.findCalibrationValueFromLine(line) shouldBe 17
    }

    """return a number composed of the first digit and last digit of line even when there are other spelled out digits
      | in between""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "aonebceightdhfivewseven"

      testObj.findCalibrationValueFromLine(line) shouldBe 17
    }

    """return a number composed of the first digit and last digit of line even when there are a mix of spelled out
      | and numeric digits in the line""".stripMargin in new SingleCalibrationValueSetup {
      override val line = "aonebc8dhfivew2seven"

      testObj.findCalibrationValueFromLine(line) shouldBe 17
    }
  }

  "findAllCalibrationValuesFromFile(path)" should {
    "throw an exception when the file in empty" in new AllCalibrationValuesSetup {
      when(fileParsing.parseFile(any)) thenReturn Success(Seq.empty)

      an[IllegalArgumentException] shouldBe thrownBy(testObj.findAllCalibrationValuesFromFile(path))
    }

    "throw an exception when the file in non empty but doesn't contain any digit" in new AllCalibrationValuesSetup {
      when(fileParsing.parseFile(any)) thenReturn Success(Seq("myFirstLine", "mySecondLine", "myThirdLine"))

      an[IllegalArgumentException] shouldBe thrownBy(testObj.findAllCalibrationValuesFromFile(path))
    }

    """return all the calibration values when the file is not empty and contains numerical
      | digits""".stripMargin in new AllCalibrationValuesSetup {
      when(fileParsing.parseFile(any)) thenReturn Success(Seq("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"))
      val expected: Seq[Int] = Seq(12, 38, 15, 77)

      testObj.findAllCalibrationValuesFromFile(path) shouldBe expected
    }

    """return all the calibration values when the file is not empty and contains a mix of numerical
      | and spelled out digits""".stripMargin in new AllCalibrationValuesSetup {
      when(fileParsing.parseFile(any)) thenReturn Success(Seq("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"))
      val expected: Seq[Int] = Seq(12, 38, 15, 77)

      testObj.findAllCalibrationValuesFromFile(path) shouldBe expected
    }
  }

  trait Setup extends TestHelper {
    val fileParsing: FileParsing = mock[FileParsing]
    val testObj: Elf = new Elf(fileParsing)
  }

  trait SingleCalibrationValueSetup extends Setup {
    def line: String
  }

  trait AllCalibrationValuesSetup extends Setup {
    val path: String = "fakePath"
  }
}
