package com.vogon101.AutoLang.Interpreter.STDLIB

import com.vogon101.AutoLang.Interpreter.{Element, Function}

/**
  * Created by Freddie on 16/02/2016.
  */
class Time extends Library{

  def getFunctions = Map (
    "time" -> new TimeFunction ()
  )

}


class TimeFunction() extends Function{

  def call (args: List[Element]):Int = {
    if (args.length != 1) {
      throw new Exception ("Time function called with wrong number of arguments")
    }
    val startTime = System.currentTimeMillis()
    args.head.run()
    val endTime   = System.currentTimeMillis()
    (endTime - startTime).toInt
  }


}
