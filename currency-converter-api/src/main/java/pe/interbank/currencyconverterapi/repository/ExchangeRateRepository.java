package pe.interbank.currencyconverterapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Integer> {

    Optional<ExchangeRate> findByCode(String code);

}
