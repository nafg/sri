package sri.mobile.examples.router.components

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{literal => json}
import scala.scalajs.js.annotation.ScalaJSDefined

import sri.core.ElementFactory._
import sri.core.ReactElement
import sri.mobile.examples.router.RouterExampleApp.{Fourth, Second}
import sri.mobile.examples.router.routes.ThirdModule
import sri.universal.components._
import sri.universal.router
import sri.universal.router.{UniversalRouterComponent, _}
import sri.universal.styles.UniversalStyleSheet

object HomeScreen {

  @ScalaJSDefined
  class Component extends UniversalRouterComponent[Unit, Unit] {
    override def render(): ReactElement = View(style = styles.container)(
      View(style = styles.row)(
        getStaticBlock("Static Second Screen", Second),
        getStaticBlock("Static Module Third Home Screen", ThirdModule.Home)
      ),
      View(style = styles.row)(
        getStaticBlock("Static Module Third Second Screen", ThirdModule.Second),
        getDynamicBlock("Dynamic Fourth Screen")
      )

    )

    def getStaticBlock(text: String, page: StaticPage) = {
      TouchableHighlight(style = styles.block,
        underlayColor = "grey",
        key = text,
        onPress = () => navigateTo(page))(
          Text(style = styles.text)(text)
        )
    }

    def getDynamicBlock(text: String) = {
      TouchableHighlight(style = styles.block,
        underlayColor = "grey",
        key = text,
        onPress = () => navigateTo(Fourth, Person("Sri"), "Sri"))(
          Text(style = styles.text)(text)
        )
    }

    def onTextClick() = {
      navigateTo(Second)
    }
  }

  js.constructorOf[Component].contextTypes = router.routerContextTypes

  def apply() = makeElement[Component]
}

object styles extends UniversalStyleSheet {

  val container = style(flexOne,
    //        alignItems.center,
    justifyContent.center,
    //    backgroundColor := "purple"
    backgroundColor := "#ED4721"
  )
  val row = style(
    flex := 1,
    flexDirection.row,
    //    flexWrap.wrap,
    margin := 10)

  val block = style(
    flex := 1,
    alignSelf.stretch,
    margin := 10,
    padding := 10,
    borderRadius := 10,
    shadowColor := "black",
    shadowOpacity := 0.5,
    shadowRadius := 2,
    shadowOffset := json(height = 1, width = 0),
    backgroundColor := "#343536",
    justifyContent.center
  )

  val text = style(fontSize := 16,
    overflow.hidden,
    textAlign.center,
    color := "grey",
    fontWeight._500)

}
