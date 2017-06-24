package jshelloworld
import subscript.language

import scala.scalajs.js.JSApp

import subscript.DSL._

object Hello extends JSApp {
  def main(): Unit = _execute(live)
  
  script live = {!println("Hello")!}
}
