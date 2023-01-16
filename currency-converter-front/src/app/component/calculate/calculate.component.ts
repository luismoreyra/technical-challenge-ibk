import { Component, OnDestroy } from '@angular/core';
import { ExchangeRate } from "../../model/exchange-rate";
import { Observable, of, Subscription } from "rxjs";
import { ExchangeServiceService } from "../../service/exchange-service.service";
import { FormControl, FormGroup } from "@angular/forms";
import { ExchangeAmountResponse } from "../../model/exchange-amount-response";

@Component({
  selector: 'app-calculate',
  templateUrl: './calculate.component.html',
  styleUrls: ['./calculate.component.css']
})
export class CalculateComponent implements OnDestroy {

  subscriptionExchangeRateList: Subscription;
  subscriptionExchangeAmount: Subscription;

  exchangeRateList$: Observable<ExchangeRate[]>;
  exchangeAmountResponse: ExchangeAmountResponse;

  exchangeAmountForm = new FormGroup({
    amount: new FormControl("1.00"),
    from: new FormControl('USD'),
    to: new FormControl('PEN'),
  });

  constructor(private exchangeRateService: ExchangeServiceService) {
    this.subscriptionExchangeRateList = this.exchangeRateService.list().subscribe((data: ExchangeRate[])  => {
      this.exchangeRateList$ = of(data);
    });
  }

  ngOnDestroy(): void {
    if(this.subscriptionExchangeRateList) {
      this.subscriptionExchangeRateList.unsubscribe();
    }
    if(this.subscriptionExchangeAmount) {
      this.subscriptionExchangeAmount.unsubscribe();
    }
  }

  convert() {
    const exchangeAmountRequest = {
      amount: this.exchangeAmountForm.controls.amount.value,
      originCurrency: this.exchangeAmountForm.controls.from.value,
      destinyCurrency: this.exchangeAmountForm.controls.to.value
    }
    this.subscriptionExchangeAmount = this.exchangeRateService.calculate(exchangeAmountRequest).subscribe(data => {
      this.exchangeAmountResponse = data;
    })
  }
}
