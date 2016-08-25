package sri.test.components

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

import sri.core.ElementFactory._
import sri.core.ReactComponent

object HelloLifeCycle {

  var willMount = false

  var willUnMount = false

  var didMount = false

  var willUpdate = false

  var didUpdate = false

  var willReceiveProps = false

  var rendered = false

  var shouldUpdate = false


  @ScalaJSDefined
  class Component extends ReactComponent[String, String] {

    initialState("")

    override def componentWillMount(): Unit = {
      willMount = true
    }

    override def componentDidMount(): Unit = {
      println(s"component did mount")
      didMount = true
    }

    @JSName("sComponentWillReceiveProps")
    override def componentWillReceiveProps(nextProps: => String): Unit = {
      willReceiveProps = true
    }

    @JSName("sComponentWillUpdate")
    override def componentWillUpdate(nextProps: => String, nextState: => String): Unit = {
        willUpdate = true
    }

    def render() = {
      rendered = true
      null
    }


    @JSName("sShouldComponentUpdate")
    override def shouldComponentUpdate(nextProps: => String, nextState: => String): Boolean = {
      shouldUpdate = true
      true
    }

    @JSName("sComponentDidUpdate")
    override def componentDidUpdate(prevProps: => String, prevState: => String): Unit = {
      didUpdate = true
    }

    override def componentWillUnmount(): Unit = {
      println(s"*********************** unmount")
    }

    def updateState() = {
      setState("newState")
    }
  }

  def apply(props : String = "hi",key: js.UndefOr[String] = js.undefined, ref: js.Function1[Component, Unit] = null) =
    makeElement[Component](props, key = "hkey", ref = ref)
}
