package com.vogon101.AutoLang.Parser

import com.vogon101.AutoLang.Interpreter.{Value, Element}

import com.vogon101.AutoLang.Interpreter.booleans._

import scala.util.parsing.combinator.{PackratParsers, JavaTokenParsers}

/**
 * Created by Freddie Poser on 16/01/2016.
 *
 */
trait BooleanParsers extends JavaTokenParsers with PackratParsers{

  val element: PackratParser[Any]

  lazy val comparison:PackratParser[Element] = element ~ rep1(("==" | "<=" | ">=" | "!=" | ">" | "<") ~ element) ^^ {
    case t ~ ts => ts.foldLeft(t) {
      case ((x:Element), "==" ~ (y:Element)) => new Equals(x,y)
      case ((x:Element), ">"  ~ (y:Element)) => new GT(x,y)
      case ((x:Element), "<"  ~ (y:Element)) => new LT(x,y)
      case ((x:Element), "<=" ~ (y:Element)) => new LTE(x,y)
      case ((x:Element), ">=" ~ (y:Element)) => new GTE(x,y)
      case ((x:Element), "!=" ~ (y:Element)) => new NotEquals(x,y)
    }.asInstanceOf[Element]
  }

  lazy val booleanExpression:PackratParser[Element] = boolean ~ rep1(("|" | "&&") ~ boolean)^^ {
    case t ~ ts => ts.foldLeft(t) {
      case (x, "&&" ~ y) => new And(x.asInstanceOf[Element], y.asInstanceOf[Element])
      case (x, "|" ~ y) => new Or(x.asInstanceOf[Element], y.asInstanceOf[Element])
    }
  }

  lazy val boolean:PackratParser[Element] = (
        "(" ~> comparison <~ ")"
      | "(" ~> booleanExpression <~ ")"
      | booleanLiteral
      | element
    ) ^^ (x=>x.asInstanceOf[Element])

  lazy val booleanLiteral: PackratParser[Value] = "true" ^^ (x=>new Value(true)) | "false" ^^ (x=>new Value(false))

}
