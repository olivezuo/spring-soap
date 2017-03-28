package com.jin.stock.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.jin.soap.client.SoapClient;
import com.jin.wsdl.GetQuote;
import com.jin.wsdl.GetQuoteResponse;

@Configuration
@ConfigurationProperties(prefix = "com.jin.stock.soap")
public class StockSoapClient extends SoapClient {
	private static final Logger log = LoggerFactory.getLogger(StockSoapClient.class);

	public GetQuoteResponse lookup(String ticker) {
		GetQuote request = new GetQuote();
		request.setSymbol(ticker);
		
		GetQuoteResponse response = (GetQuoteResponse) this.GetResponse(request, "http://www.webserviceX.NET/GetQuote");
		log.info("The response is: " + response.toString());
		return response;
	}
	
}
