package com.cav.spring.service.bank.model.account;

import java.util.ArrayList;
import java.util.List;

public class AccountRequest {
	
	private Long clientId;
	private List <AccountId> accountIds = new ArrayList<AccountId>();

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public List<AccountId> getAccountIds() {
		return accountIds;
	}

	public void setAccountIds(List<AccountId> accountIds) {
		this.accountIds = accountIds;
	}
}
