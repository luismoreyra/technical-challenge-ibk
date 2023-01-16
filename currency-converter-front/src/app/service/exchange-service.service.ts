import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { ExchangeRate } from "../model/exchange-rate";
import { UpdateExchangeRateRequest } from "../model/update-exchange-rate-request";
import { UpdateExchangeRateResponse } from "../model/update-exchange-rate-response";
import { ExchangeAmountRequest } from "../model/exchange-amount-request";
import { ExchangeAmountResponse } from "../model/exchange-amount-response";

@Injectable({
  providedIn: 'root'
})
export class ExchangeServiceService {

  API_BASE = "http://localhost:8080/currency-converter/api/";

  constructor(private httpClient: HttpClient) { }

  list(): Observable<ExchangeRate[]> {
    return this.httpClient.get<ExchangeRate[]>(this.API_BASE + 'list');
  }

  calculate(exchangeAmountRequest: any): Observable<ExchangeAmountResponse> {
    return this.httpClient.post<ExchangeAmountResponse>(this.API_BASE + 'calculate', exchangeAmountRequest);
  }

  update(updateExchangeRateRequest: any): Observable<UpdateExchangeRateResponse> {
    return this.httpClient.post<UpdateExchangeRateResponse>(this.API_BASE + 'update', updateExchangeRateRequest);
  }

}
