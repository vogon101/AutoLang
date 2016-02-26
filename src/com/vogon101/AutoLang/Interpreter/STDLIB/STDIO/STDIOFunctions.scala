package com.vogon101.AutoLang.Interpreter.STDLIB.STDIO

import com.vogon101.AutoLang.Interpreter.{Program, Element, Function}
import com.vogon101.AutoLang.Interpreter.STDLIB.Library

import scala.io.StdIn


/**
 * Library for input and output
 */
class STDIOFunctions extends Library {

  def getFunctions = {
    Map(
      "print" -> new PrintFunction( ),
      "input" -> new ReadLineFunction( ),
      "require" -> new RequireLibFunction( )
    )
  }

}


class PrintFunction() extends Function{

  def call (args: List[Element]): Any = {
    var results = List[Any]()
    args.foreach(x=>{
      val r = x.run()
      results = results :+ r
      print(r)
    })
    //println(args.tail.run())
    if(args.nonEmpty && results(results.length-1) != "")
      println()
  }


}


class ReadLineFunction () extends Function {

  def call (args: List[Element]): Any = {
    if (args.length > 1) {
      throw new IllegalArgumentException ("Too many arguments for input function")
    }
    if (args.isEmpty)
      return StdIn.readLine()
    StdIn.readLine(args.head.run().toString)
  }

}


class RequireLibFunction () extends Function {

  def call (args: List[Element]): Any = {
    if (args.length != 1) {
     throw new IllegalArgumentException ("Wrong number of arguments for require function")
    }

    val name = args.head.run().toString
    val lib = Program.libs.get(name)
    if (lib.isEmpty) {
      throw new Exception (s"Library $name is not available")
    }
    Program.p.loadLib(lib.get)


  }

}