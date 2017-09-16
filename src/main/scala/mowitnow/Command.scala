package mowitnow

sealed trait Command

case object Forward extends Command
case object Left extends Command
case object Right extends Command
