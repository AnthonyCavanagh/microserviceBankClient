package com.cav.spring.service.bank.model.client;

import java.time.LocalDate;

public class Client {
		
		private long clientid;
		private String clientName;
		private LocalDate effectiveDate;
		private String clientActive;
		public long getClientid() {
			return clientid;
		}
		public void setClientid(long clientid) {
			this.clientid = clientid;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public LocalDate getEffectiveDate() {
			return effectiveDate;
		}
		public void setEffectiveDate(LocalDate effectiveDate) {
			this.effectiveDate = effectiveDate;
		}
		public String getClientActive() {
			return clientActive;
		}
		public void setClientActive(String clientActive) {
			this.clientActive = clientActive;
		}

}
