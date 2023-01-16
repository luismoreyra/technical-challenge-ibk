package pe.interbank.currencyconverterapi.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeAmountRequest {

    private String amount;

    @JsonProperty("origin_currency")
    private String originCurrency;

    @JsonProperty("destiny_currency")
    private String destinyCurrency;

}
