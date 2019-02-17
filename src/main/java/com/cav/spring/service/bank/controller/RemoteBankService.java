package com.cav.spring.service.bank.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cav.spring.service.bank.config.BankClientConfiguration;
import com.cav.spring.service.bank.model.account.AccountRequest;
import com.cav.spring.service.bank.model.account.Accounts;
import com.cav.spring.service.bank.model.bank.BankRequest;
import com.cav.spring.service.bank.model.bank.Banks;
import com.cav.spring.service.bank.model.funds.FundRequest;
import com.cav.spring.service.bank.model.funds.Funds;

@FeignClient(name="bankservice",  configuration = BankClientConfiguration.class)
public interface RemoteBankService {
	
	@RequestMapping(method=RequestMethod.GET, value="/bankservice/")
	public String home();
	
	
	@RequestMapping(value = "/bankservice/findbanks/", method = RequestMethod.POST)
	public Banks findBanks(@RequestBody BankRequest request);
	
	@RequestMapping(value = "/bankservice/findaccounts/", method = RequestMethod.POST)
	public Accounts findAccounts(@RequestBody AccountRequest request);
	
	@RequestMapping(value = "/bankservice/findfunds/", method = RequestMethod.POST)
	public Funds findFunds(@RequestBody FundRequest request);

}
