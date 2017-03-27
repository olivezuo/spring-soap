package com.jin.soap.client;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.jin.soap.config.SoapConfig;

@Service
public class SoapClient extends WebServiceGatewaySupport {
	private static final Logger log = LoggerFactory.getLogger(SoapClient.class);
	
	@Autowired
	SoapConfig soapConfig;
	
	@PostConstruct
	protected void init() {
		this.setDefaultUri(soapConfig.getDefaultUri());
		this.setMarshaller(soapConfig.marshaller());
		this.setUnmarshaller(soapConfig.marshaller());
	}

	public Object GetResponse (Object request, String soapActionCallBack) {
		return this.GetResponse(request, soapActionCallBack, soapConfig.getDefaultUri());
		
	}
	
	public Object GetResponse(Object request, String soapActionCallBack, String uri){
		
		log.info("The request is: " + request.toString());
		Object response = getWebServiceTemplate()
				.marshalSendAndReceive(uri,
						request,
						new SoapActionCallback(soapActionCallBack));
		
		return response;
		
	}

}
