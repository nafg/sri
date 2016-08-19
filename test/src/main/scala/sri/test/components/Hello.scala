package sri.test.components

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.annotation.ScalaJSDefined

import sri.core.ElementFactory._
import sri.core.ReactComponent

object Hello {


  @ScalaJSDefined
  class Component extends ReactComponent[String, Unit] {
    def render() = null
  }

  def apply(key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, Unit] = null) =
    makeElement[Component]("hi", key = "hkey", ref = ref)
}
