package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MaxPerf extends Simulation{

  setUp(
    CommonScenario()
      .inject(
        rampUsers(1).during(20),
        constantUsersPerSec(1).during(300),
        rampUsersPerSec(1).to(2).during(20),
        constantUsersPerSec(2).during(300),
        rampUsersPerSec(2).to(3).during(20),
        constantUsersPerSec(3).during(300),
        rampUsersPerSec(3).to(4).during(20),
        constantUsersPerSec(4).during(300)

      )
      .protocols(httpProtocol)
  )

}
