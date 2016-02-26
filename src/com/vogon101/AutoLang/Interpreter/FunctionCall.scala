package com.vogon101.AutoLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
class FunctionCall (name:String, args:List[Element]) extends Element{

  def run():Any = {
    val function = Program().scope.get[Function](name)
    function.call(args)
  }

  override def simplify() = new FunctionCall (name, args.map(_.simplify()))

  override def debug(): Unit = {
    println(s"Function Call of $name")
    println("ARGS")
    args.foreach(_.debug())
    println("ENDARGS")
    super.debug()
  }

}
