package sri.mobile.examples.uiexplorer

import scala.scalajs.js.annotation.ScalaJSDefined

import sri.core.ElementFactory._
import sri.core.{ReactComponent, _}
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

object UIExplorerPage {


  @ScalaJSDefined
  class Component extends ReactComponent[Unit, Unit] {


    def render() = {
      ScrollView(style = UniversalStyleSheet.wholeContainer, keyboardShouldPersistTaps = true,
        keyboardDismissMode = keyboardDismissMode.INTERACTIVE)(
          children
        )
    }

  }

  def apply(children: ReactNode*) = makeElementNoPropsWithChildren[Component]()(children: _*)
}
