package perf

import io.gatling.core.Predef._
import io.gatling.core.structure.{ChainBuilder, ScenarioBuilder}
import io.gatling.http.Predef._

object CommonScenario {
  def apply() = new CommonScenario().scn
}

class CommonScenario {

  val rootPageGroup: ChainBuilder = group("root page") {
    exec(Action.welcomeRootPage)
      .exec(Action.navRootPage)
  }

  val loginGroup: ChainBuilder = group("login action") {
    exec(Action.login)
      .exec(Action.getNavMenuInWelcomePage)
      .exec(Action.getWelcomePage)
  }

  val findFlightPage: ChainBuilder = group("find flight page") {
    exec(Action.flightsBtnAction)
      .exec(Action.getNavMenuInFlightsPage)
      .exec(Action.getFindFlightPage)
  }
  val scn: ScenarioBuilder = scenario("webtours")
    .exec(rootPageGroup)
    .exec(loginGroup)
    .exec(findFlightPage)
    .exec(Action.chooseCitiesAction)
    .exec(Action.chooseFlightAction)
    .exec(Action.buyTicketAction)
    .exec(Action.singoffBtnAction)
    .exec(Action.navRootPage)


}
