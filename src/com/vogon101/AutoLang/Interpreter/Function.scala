package com.vogon101.AutoLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 */
abstract class Function {

  def call (args: List[Element]): Any

}
