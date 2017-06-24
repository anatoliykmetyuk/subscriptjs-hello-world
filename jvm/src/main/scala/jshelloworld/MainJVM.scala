package jshelloworld
import subscript.language

import subscript.DSL._

object Hello {
  def main( args: Array[String]): Unit = _execute(live)
  
  script live = {!println("Hello")!}
}
