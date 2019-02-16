package com.example.demo.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CurrencyConversion;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@HystrixCommand(fallbackMethod = "defaultResponse")
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//
//		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
//				"http://localhost:8081/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
//
//		CurrencyConversion response = responseEntity.getBody();

		CurrencyConversion response = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	private CurrencyConversion defaultResponse(String from, String to, BigDecimal quantity) {
		CurrencyConversion conversion = new CurrencyConversion();
		return conversion;
	}

}