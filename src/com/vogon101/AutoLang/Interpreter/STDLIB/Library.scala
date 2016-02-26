package com.vogon101.AutoLang.Interpreter.STDLIB

import com.vogon101.AutoLang.Interpreter.Function

/**
 * Contains a map of functions that can be added to a Program so they can be accessed
 */
abstract class Library {

  def getFunctions: Map[String,Function]

}
