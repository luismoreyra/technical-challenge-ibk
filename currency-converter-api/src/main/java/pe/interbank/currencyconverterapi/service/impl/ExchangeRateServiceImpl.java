package pe.interbank.currencyconverterapi.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountRequest;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountResponse;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateRequest;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateResponse;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;
import pe.interbank.currencyconverterapi.repository.ExchangeRateRepository;
import pe.interbank.currencyconverterapi.service.ExchangeRateService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeAmountResponse calculate(ExchangeAmountRequest exchangeAmountRequest) {
        ExchangeRate exchangeRate = this.getExchangeRateByCode(exchangeAmountRequest.getDestinyCurrency());
        ExchangeAmountResponse exchangeAmountResponse = new ExchangeAmountResponse();
        exchangeAmountResponse.setAmount(exchangeAmountRequest.getAmount());
        exchangeAmountResponse.setOriginCurrency(exchangeAmountRequest.getOriginCurrency());
        exchangeAmountResponse.setDestinyCurrency(exchangeAmountRequest.getDestinyCurrency());

        BigDecimal amount = new BigDecimal(exchangeAmountRequest.getAmount());
        exchangeAmountResponse.setAmountExchange(amount.multiply(exchangeRate.getRate()).setScale(10, RoundingMode.CEILING).toPlainString());
        exchangeAmountResponse.setRateExchange(exchangeRate.getRate().toPlainString());

        return exchangeAmountResponse;
    }

    @Override
    public UpdateExchangeRateResponse update(UpdateExchangeRateRequest updateExchangeRateRequest) {
        ExchangeRate exchangeRate = this.getExchangeRateByCode(updateExchangeRateRequest.getCode());
        String oldRate = exchangeRate.getRate().toPlainString();
        exchangeRate.setRate(new BigDecimal(updateExchangeRateRequest.getRate()));
        this.exchangeRateRepository.save(exchangeRate);

        UpdateExchangeRateResponse exchangeRateResponse = new UpdateExchangeRateResponse();
        exchangeRateResponse.setCode(updateExchangeRateRequest.getCode());
        exchangeRateResponse.setRate(updateExchangeRateRequest.getRate());
        exchangeRateResponse.setOldRate(oldRate);
        return exchangeRateResponse;
    }

    @Override
    public List<ExchangeRate> list() {
        return this.exchangeRateRepository.findAll();
    }

    private ExchangeRate getExchangeRateByCode(String code) {
        Optional<ExchangeRate> exchangeRate = this.exchangeRateRepository.findByCode(code);
        return exchangeRate.orElseThrow(RuntimeException::new); // TODO: throw custom exception
    }

}
