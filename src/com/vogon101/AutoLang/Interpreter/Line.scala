package com.vogon101.AutoLang.Interpreter

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
abstract class Line {

  def run():Any

  def debug(): Unit ={
    println("LINE")
  }

  def simplify(): Line = this

}
