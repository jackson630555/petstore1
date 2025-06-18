package simulations
import io.gatling.http.Predef._
import io.gatling.core.Predef._

class PetStore extends Simulation{
  val httpconfig = http.baseUrl("https://petstore.swagger.io/")
  val sessionheaders = Map("cookie" ->"cookiehub=eyJhbnN3ZXJlZCI6dHJ1ZSwicmV2aXNpb24iOjEsImRudCI6ZmFsc2UsImFsbG93U2FsZSI6dHJ1ZSwiaW1wbGljdCI6ZmFsc2UsInJlZ2lvbiI6IkM0IiwidG9rZW4iOiIxQ0NvNnIwUTZ1YUx4dzJHdGRyVmU5aXBJWWREZjI0c3cwR1RTYmtBaDdsanJUTDZDUzhWQnc2YUdOb2ZZUXdCIiwidGltZXN0YW1wIjoiMjAyNS0wNC0yOVQxMzoyNToxMS43ODdaIiwiYWxsQWxsb3dlZCI6dHJ1ZSwiY2F0ZWdvcmllcyI6W10sInZlbmRvcnMiOltdLCJzZXJ2aWNlcyI6W10sImltcGxpY2l0IjpmYWxzZX0=; _ga=GA1.1.1443043488.1745933091; userId=54484321745933112053; cebs=1; _ce.clock_data=1992%2C223.228.101.4%2C1%2C0fe6feb54289f4c67027ec06cc2131f8%2CChrome%2CIN; cebsp_=1; _ce.s=v~a2b8bab7517f0404f752a718cc2aad79646b5032~lcw~1750229138808~vir~new~lva~1750229138438~vpv~1~v11.fsvd~eyJ1cmwiOiJwZXRzdG9yZS5zd2FnZ2VyLmlvIiwicmVmIjoiaHR0cHM6Ly93d3cuZ29vZ2xlLmNvbS8iLCJ1dG0iOltdfQ%3D%3D~v11.cs~243208~v11.s~d8723870-4c0f-11f0-a270-b5abe46a4648~v11.vs~a2b8bab7517f0404f752a718cc2aad79646b5032~v11ls~d8723870-4c0f-11f0-a270-b5abe46a4648~lcw~1750229138812; _ga_F11FV1HQ2E=GS2.1.s1750229136$o2$g1$t1750229157$j39$l0$h0","accept" ->"application/json")

  val scn = scenario("PetStore API calls")
    .exec(
      http("PetStore details based on ID")
        .get("v2/pet/12")
        .headers(sessionheaders)
    )
  setUp(scn.inject(atOnceUsers(1))).protocols(httpconfig)

}
