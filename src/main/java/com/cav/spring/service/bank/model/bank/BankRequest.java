package com.cav.spring.service.bank.model.bank;

import java.util.ArrayList;
import java.util.List;

public class BankRequest {
	
	private List <BankId> bankIds = new ArrayList<BankId>();
	private Long clientId;
	private boolean accounts = true;
	private boolean funds = true;
	
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public List<BankId> getBankIds() {
		return bankIds;
	}

	public void setBankIds(List<BankId> bankIds) {
		this.bankIds = bankIds;
	}

	public boolean isAccounts() {
		return accounts;
	}

	public void setAccounts(boolean accounts) {
		this.accounts = accounts;
	}

	public boolean isFunds() {
		return funds;
	}

	public void setFunds(boolean funds) {
		this.funds = funds;
	}
}
