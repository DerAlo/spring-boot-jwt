package com.devglan.controller;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.bitstamp.BitstampExchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.model.ApiResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/exchange")
public class ExchangeController {

	@GetMapping
	public ApiResponse<String> getOne() {
		// Use the factory to get Bitstamp exchange API using default settings
		Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
		// Interested in the public market data feed (no authentication)
		MarketDataService marketDataService = bitstamp.getMarketDataService();
		Ticker ticker;
		try {
			ticker = marketDataService.getTicker(CurrencyPair.BTC_USD);
		} catch (IOException e) {
			return new ApiResponse<String>(HttpStatus.I_AM_A_TEAPOT.value(), "Error.", e.getMessage());
		}
		return new ApiResponse<String>(HttpStatus.OK.value(), "Done.", ticker.toString());
	}

}
