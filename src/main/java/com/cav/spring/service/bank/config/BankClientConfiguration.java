package com.cav.spring.service.bank.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import feign.codec.Encoder;


public class BankClientConfiguration {

	public Encoder feignEncoder() {
    	HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter();
    	ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
    	return new SpringEncoder(objectFactory);

	}
}
