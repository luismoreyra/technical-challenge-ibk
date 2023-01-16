package pe.interbank.currencyconverterapi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeAmountResponse {

    private String amount;

    private String originCurrency;

    private String destinyCurrency;

    private String amountExchange;

    private String rateExchange;

}
