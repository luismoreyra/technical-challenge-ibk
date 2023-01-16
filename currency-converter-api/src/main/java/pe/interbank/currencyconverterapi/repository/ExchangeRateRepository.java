package pe.interbank.currencyconverterapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.interbank.currencyconverterapi.repository.entity.ExchangeRate;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {

    Optional<ExchangeRate> findByCode(String code);

}
