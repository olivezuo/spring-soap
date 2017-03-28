package com.jin.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.stock.client.StockSoapClient;
import com.jin.wsdl.GetQuoteResponse;

@Service
public class StockService {
	
	private static final Logger log = LoggerFactory.getLogger(StockService.class);
	
	@Autowired
	StockSoapClient stockSoapClient;
	
	public GetQuoteResponse lookup(String ticker) {
		return stockSoapClient.lookup(ticker);
	}
}
