package org.knowm.xchange.bittrex;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.knowm.xchange.bittrex.dto.marketdata.BittrexChartDataResponse;

@Path("v2.0")
@Produces(MediaType.APPLICATION_JSON)
public interface BittrexV2 {

  @GET
  @Path("pub/market/getticks")
  BittrexChartDataResponse getChartData(@QueryParam("marketname") String market, @QueryParam("tickinterval") String tickInterval) throws IOException;

  @GET
  @Path("pub/market/GetLatestTick")
    //Probably _ is a timestamp. tickInterval must be in [“oneMin”, “fiveMin”, “thirtyMin”, “hour”, “day”].
  BittrexChartDataResponse getLatestTick(@QueryParam("marketName") String market, @QueryParam("tickInterval") String tickInterval,
      @QueryParam("_") Long timeStamp);
}
