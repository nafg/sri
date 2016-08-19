package sri.test.router

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{JSON, UndefOr => U}

import sri.core.ReactComponent
import sri.test.components.Text
import sri.web.all._
import sri.web.router.WebRoute


object StaticStateScreen {


  @ScalaJSDefined
  class Component extends ReactComponent[WebRoute, Unit] {
    def render() = {
      Text()(s"Welcome to StaticState Screen, State you passed is : ${JSON.stringify(props.state.getOrElse(js.Dictionary()))}")
    }
  }


  def apply(route: WebRoute, key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, Unit] = null) =
    makeElement[Component](route, key = key, ref = ref)
}
