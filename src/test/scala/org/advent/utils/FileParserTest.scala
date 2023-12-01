package org.advent.utils

import org.advent.helpers.{TestBase, TestHelper}
import org.scalatest.{Assertion, TryValues}

import scala.util.Try

class FileParserTest extends TestBase {

  "parse(path)" should {
    "throw an exception when the file could not be opened" in new Setup {
      val result: Try[Seq[String]] = testObj.parseFile("randomPath")

      result.isFailure shouldBe true
      result.failed.get shouldBe a[Throwable]
    }

    "return an empty string when the file located at path is empty" in new Setup {
      val result: Try[Seq[String]] = testObj.parseFile(s"$pathPrefix$emptyFileName")

      result.isSuccess shouldBe true
      result.get shouldBe Seq.empty
    }

    "return a sequence of string containing all the lines of the file when the file located at path is non-empty" in new Setup {
      val result: Try[Seq[String]] = testObj.parseFile(s"$pathPrefix$nonEmptyFileName")

      result.isSuccess shouldBe true
      result.get shouldBe Seq("myFirstLine", "mySecondLine", "myThirdLine")
    }
  }

  trait Setup extends TestHelper {
    val testObj: FileParser.type = FileParser
  }
}