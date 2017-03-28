package com.jin.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jin.stock.service.StockService;
import com.jin.wsdl.GetQuoteResponse;

@RestController
public class SoapController {
	
	@Autowired
	StockService stockService;

	@RequestMapping(method=RequestMethod.GET, value="/stock/{ticker}", produces = { "application/xml"})
	public GetQuoteResponse lookup(@PathVariable String ticker) {
		return stockService.lookup(ticker);
	}

}
