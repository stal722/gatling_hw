import io.gatling.core.Predef._
import io.gatling.http.Predef._

package object perf {

    val httpProtocol = http
      .baseUrl("http://webtours.load-test.ru:1080")
      .acceptEncodingHeader("gzip, deflate")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif," +
        "image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
      .acceptLanguageHeader("ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36")

}


