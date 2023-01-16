package pe.interbank.currencyconverterapi.service;

import pe.interbank.currencyconverterapi.bean.ExchangeAmountRequest;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountResponse;

public interface ExchangeRateService {

    ExchangeAmountResponse calculate(ExchangeAmountRequest exchangeAmountRequest);

}
