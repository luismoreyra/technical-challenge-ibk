package pe.interbank.currencyconverterapi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateExchangeRateRequest {

    private String code;

    private String rate;

}
