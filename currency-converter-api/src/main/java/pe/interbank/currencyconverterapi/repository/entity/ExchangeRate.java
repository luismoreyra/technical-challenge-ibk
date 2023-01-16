package pe.interbank.currencyconverterapi.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class ExchangeRate {

    @Id
    private int id;

    @Column(length = 3)
    private String code;

    @Column(length = 500)
    private String description;

    @Column(length = 500)
    private String country;

    @Column
    private BigDecimal rate;

    @Column
    private Boolean enabled;

}
