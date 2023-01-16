package pe.interbank.currencyconverterapi.service;

import pe.interbank.currencyconverterapi.bean.ExchangeAmountRequest;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountResponse;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateRequest;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateResponse;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateService {

    ExchangeAmountResponse calculate(ExchangeAmountRequest exchangeAmountRequest);

    UpdateExchangeRateResponse update(UpdateExchangeRateRequest updateExchangeRateRequest);

    List<ExchangeRate> list();

}
