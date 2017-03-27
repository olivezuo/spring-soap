package com.jin.soap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.soap.client.SoapClient;
import com.jin.wsdl.GetQuote;
import com.jin.wsdl.GetQuoteResponse;

@Service
public class SoapService {
	
	private static final Logger log = LoggerFactory.getLogger(SoapService.class);
	@Autowired 
	SoapClient soapClient;
	
	public GetQuoteResponse lookup(String ticker) {
		GetQuote request = new GetQuote();
		request.setSymbol(ticker);
		
		GetQuoteResponse response = (GetQuoteResponse) soapClient.GetResponse(request, "http://www.webserviceX.NET/GetQuote");
		log.info("The response is: " + response.toString());
		return response;
	}

}
