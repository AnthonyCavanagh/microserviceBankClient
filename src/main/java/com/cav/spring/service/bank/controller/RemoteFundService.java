package com.cav.spring.service.bank.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cav.spring.service.bank.config.BankClientConfiguration;
import com.cav.spring.service.bank.model.funds.FundPOJO;
import com.cav.spring.service.bank.model.funds.FundRequest;
import com.cav.spring.service.bank.model.funds.Funds;

@FeignClient(name="fundservice",  configuration = BankClientConfiguration.class)
public interface RemoteFundService {
	
	@RequestMapping(method=RequestMethod.GET, value="/fundservice/")
	public String home();
	
	@RequestMapping(method=RequestMethod.GET, value="/fundservice/getfund/{fundId}/")
	public FundPOJO getFundById(@PathVariable(value="fundId") Long fundId);
	
	@RequestMapping(value = "/fundservice/findfunds/", method = RequestMethod.POST)
	public Funds findFunds(@RequestBody FundRequest request);

}
