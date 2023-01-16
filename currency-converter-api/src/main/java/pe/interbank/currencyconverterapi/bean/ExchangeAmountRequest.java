package pe.interbank.currencyconverterapi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeAmountRequest {

    private String amount;

    private String originCurrency;

    private String destinyCurrency;

}
