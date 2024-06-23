package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Reliability extends Simulation{

  setUp(
    CommonScenario()
      .inject(
        rampUsers(2).during(60),
        constantUsersPerSec(2).during(3600)
      )
      .protocols(httpProtocol)
  )

}
