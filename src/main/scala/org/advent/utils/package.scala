package org.advent

import scala.util.matching.Regex

package object utils {
  val nonNullIntegerPattern: Regex = "[1-9][0-9]*".r
}
