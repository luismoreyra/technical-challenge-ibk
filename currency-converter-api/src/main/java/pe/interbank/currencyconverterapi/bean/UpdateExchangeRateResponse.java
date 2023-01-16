package pe.interbank.currencyconverterapi.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateExchangeRateResponse {

    private String code;

    private String rate;

    private String oldRate;

}
