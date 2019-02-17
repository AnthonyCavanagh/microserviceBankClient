package com.cav.spring.service.bank.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cav.spring.service.bank.model.account.AccountRequest;
import com.cav.spring.service.bank.model.account.Accounts;
import com.cav.spring.service.bank.model.bank.BankRequest;
import com.cav.spring.service.bank.model.bank.Banks;
import com.cav.spring.service.bank.model.client.Client;
import com.cav.spring.service.bank.model.funds.FundRequest;
import com.cav.spring.service.bank.model.funds.Funds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RefreshScope
@RestController
@RequestMapping("/bankclient")
public class BankClientController {

	@Autowired
	RemoteFundService remoteFundService;

	@Autowired
	RemoteBankService remoteBankService;

	@Autowired
	RemoteAuthenticationService authenticationService;

	private static final Logger logger = LoggerFactory.getLogger(BankClientController.class);

	@RequestMapping(value = "/")
	public String fund() {
		return remoteBankService.home();
	}

	@RequestMapping(value = "/findfunds/", method = RequestMethod.POST)
	public Funds getFunds(@RequestBody FundRequest request) {
		Client client = authenticationService.getClient(request.getClientId());
		if (client != null) {
			if (client.getClientActive().equals("Y") && client.getEffectiveDate().isBefore(LocalDate.now())) {
				Funds funds = remoteBankService.findFunds(request);
				return funds;
			}
			logger.error("Client "+request.getClientId()+" failed on "+client.getClientActive() + ", "+client.getEffectiveDate());

		} else {
			logger.error("No error for client "+request.getClientId());
		}
		return null;
	}

	@RequestMapping(value = "/findaccounts/", method = RequestMethod.POST)
	public Accounts getAccounts(@RequestBody AccountRequest request) {
		Client client = authenticationService.getClient(request.getClientId());
		if (client != null) {
			if (client.getClientActive().equals("Y") && client.getEffectiveDate().isBefore(LocalDate.now())) {
				return remoteBankService.findAccounts(request);
			}
			logger.error("Client "+request.getClientId()+" failed on "+client.getClientActive() + ", "+client.getEffectiveDate());

		} else {
			logger.error("No error for client "+request.getClientId());
		}
		return null;
	}

	@RequestMapping(value = "/findfindbanks/", method = RequestMethod.POST)
	public Banks getAccounts(@RequestBody BankRequest request) {
		Client client = authenticationService.getClient(request.getClientId());
		if (client != null) {
			if (client.getClientActive().equals("Y") && client.getEffectiveDate().isBefore(LocalDate.now())) {
				return remoteBankService.findBanks(request);
			}
			logger.error("Client "+request.getClientId()+" failed on "+client.getClientActive() + ", "+client.getEffectiveDate());

		} else {
			logger.error("No error for client "+request.getClientId());
		}
		return null;
	}

}
