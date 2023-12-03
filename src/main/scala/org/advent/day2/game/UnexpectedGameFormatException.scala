package org.advent.day2.game

case class UnexpectedGameFormatException(message: String = "") extends Exception(message)
case class UnexpectedCubeDescriptionFormatException(message: String = "") extends Exception(message)
