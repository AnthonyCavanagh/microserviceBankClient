package com.cav.spring.service.bank.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cav.spring.service.bank.model.client.Client;

@FeignClient(name="authenticationService")
public interface RemoteAuthenticationService {
	
	@RequestMapping(method=RequestMethod.GET, value="/authenticationservice/")
	public String home();
	
	@RequestMapping(method=RequestMethod.GET, value="/authenticationservice/getClient/{clientId}/")
	public Client getClient(@PathVariable("clientId") Long clientId);

}
