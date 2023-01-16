package pe.interbank.currencyconverterapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountRequest;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountResponse;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;
import pe.interbank.currencyconverterapi.repository.ExchangeRateRepository;
import pe.interbank.currencyconverterapi.service.ExchangeRateService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeAmountResponse calculate(ExchangeAmountRequest exchangeAmountRequest) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByCode(exchangeAmountRequest.getDestinyCurrency());
        ExchangeAmountResponse exchangeAmountResponse = new ExchangeAmountResponse();
        exchangeAmountResponse.setAmount(exchangeAmountRequest.getAmount());
        exchangeAmountResponse.setOriginCurrency(exchangeAmountRequest.getOriginCurrency());
        exchangeAmountResponse.setDestinyCurrency(exchangeAmountRequest.getDestinyCurrency());

        BigDecimal amount = new BigDecimal(exchangeAmountRequest.getAmount());
        BigDecimal rate = exchangeRate.orElseThrow(RuntimeException::new).getRate(); // TODO: throw custom exception
        exchangeAmountResponse.setAmountExchange(amount.multiply(rate).setScale(10, RoundingMode.CEILING).toPlainString());
        exchangeAmountResponse.setRateExchange(rate.toPlainString());

        return exchangeAmountResponse;
    }

}
