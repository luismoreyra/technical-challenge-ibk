package pe.interbank.currencyconverterapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountRequest;
import pe.interbank.currencyconverterapi.bean.ExchangeAmountResponse;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateRequest;
import pe.interbank.currencyconverterapi.bean.UpdateExchangeRateResponse;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;
import pe.interbank.currencyconverterapi.service.ExchangeRateService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ExchangeRateController {

    ExchangeRateService exchangeRateService;

    @PostMapping(value = "calculate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ExchangeAmountResponse calculate(@RequestBody ExchangeAmountRequest exchangeAmountRequest) {
        return exchangeRateService.calculate(exchangeAmountRequest);
    }

    @PostMapping(value = "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UpdateExchangeRateResponse calculate(@RequestBody UpdateExchangeRateRequest updateExchangeRateRequest) {
        return exchangeRateService.update(updateExchangeRateRequest);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ExchangeRate> list() {
        return exchangeRateService.list();
    }

}
