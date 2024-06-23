
package perf

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

object Action {

  val welcomeRootPage: HttpRequestBuilder = http("welcome root page")
    .get("/cgi-bin/welcome.pl")
    .queryParam("singOff", "true")
    .check(status is 200)

  val navRootPage: HttpRequestBuilder = http("nav root page")
    .get("/cgi-bin/nav.pl")
    .queryParam("in", "home")
    .check(regex("""<input type="hidden" name="userSession" value="([0-9a-zA-Z-#()/. ]+)"/>""").saveAs("userSession"))

  val login: HttpRequestBuilder = http("login action")
    .post("/cgi-bin/login.pl")
    .formParam("userSession", "#{userSession}")
    .formParam("username", "jojo")
    .formParam("password", "bean")
    .formParam("login.x", "0")
    .formParam("login.y", "0")
    .formParam("JSFormSubmit", "off")
    .check(status is 200)

  val getNavMenuInWelcomePage: HttpRequestBuilder = http("get nav menu in welcome page")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "home")
    .check(status is 200)

  val getWelcomePage: HttpRequestBuilder = http("get welcome page")
    .get("/cgi-bin/login.pl")
    .queryParam("intro", "true")
    .check(status is 200)

  val flightsBtnAction: HttpRequestBuilder = http("flights btn action")
    .get("/cgi-bin/welcome.pl")
    .queryParam("page", "search")
    .check(status is 200)

  val getNavMenuInFlightsPage: HttpRequestBuilder = http("get nav menu in flights page")
    .get("/cgi-bin/nav.pl")
    .queryParam("page", "menu")
    .queryParam("in", "flights")
    .check(status is 200)

  val getFindFlightPage: HttpRequestBuilder = http("get find flight page")
    .get("/cgi-bin/reservations.pl")
    .queryParam("page", "welcome")
    .check(css("select[name='depart'] option", "value").findRandom.saveAs("departCity"))
    .check(css("select[name='arrive'] option", "value").findRandom.saveAs("arriveCity"))

  val chooseCitiesAction: HttpRequestBuilder = http("choose city action")
    .post("/cgi-bin/reservations.pl")
    .formParam("advanceDiscount", "0")
    .formParam("depart", "#{departCity}")
    .formParam("departDate", "06/24/2024")
    .formParam("arrive", "#{arriveCity}")
    .formParam("returnDate", "06/25/2024")
    .formParam("numPassengers", "1")
    .formParam("seatPref", "None")
    .formParam("seatType", "Coach")
    .formParam("findFlights.x", "57")
    .formParam("findFlights.y", "9")
    .formParam(".cgifields", "roundtrip")
    .formParam(".cgifields", "seatType")
    .formParam(".cgifields", "seatPref")
    .check(css("input[name='outboundFlight']", "value").findRandom.saveAs("flight"))

  val chooseFlightAction: HttpRequestBuilder = http("choose flight action")
    .post("/cgi-bin/reservations.pl")
    .formParam("outboundFlight", "#{flight}")
    .formParam("numPassengers", "1")
    .formParam("advanceDiscount", "0")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("reserveFlights.x", "47")
    .formParam("reserveFlights.y", "14")
    .check(status is 200)

  val buyTicketAction: HttpRequestBuilder = http("buy ticket action")
    .post("/cgi-bin/reservations.pl")
    .formParam("firstName", "Jojo")
    .formParam("lastName", "Bean")
    .formParam("address1", "addr1")
    .formParam("address2", "addr2")
    .formParam("pass1", "Jojo Bean")
    .formParam("creditCard", "12345")
    .formParam("expDate", "12/24")
    .formParam("oldCCOption", "")
    .formParam("numPassengers", "1")
    .formParam("seatType", "Coach")
    .formParam("seatPref", "None")
    .formParam("outboundFlight", "#{flight}")
    .formParam("advanceDiscount", "0")
    .formParam("returnFlight", "")
    .formParam("JSFormSubmit", "off")
    .formParam("buyFlights.x", "48")
    .formParam("buyFlights.y", "9")
    .formParam(".cgifields", "saveCC")
    .check(status is 200)

  val singoffBtnAction: HttpRequestBuilder = http("sing off btn action")
    .get("/cgi-bin/welcome.pl")
    .queryParam("singOff", "1")
    .check(status is 200)






}
