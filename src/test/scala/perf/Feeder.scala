package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Feeder {

  val myFeedOtus = csv("otus.csv").random

}
