package chandu0101.scalajs.sri.web.examples

import chandu0101.scalajs.sri.web.router._

object AppRouter {

  case object Home extends StaticContent

  case object Second extends StaticContent
//
//  object config extends WebRouterConfig {
//    override def initialRoute: (StaticContent, StaticRoute) = (Home,StaticRoute(component = () => Hello(),path = "/"))
//
//    staticRoute(Second,StaticRoute(path = "/second",component = () => SecondC()))
//  }

//  val router = WebRouter(config)

}