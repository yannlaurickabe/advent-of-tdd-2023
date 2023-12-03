package org.advent.day2

import scala.util.matching.Regex

package object game {
  val nonNullIntegerPattern: Regex = "[1-9][0-9]*".r
}
