import { Component, OnDestroy, OnInit } from '@angular/core';
import { ExchangeServiceService } from "../../service/exchange-service.service";
import { ExchangeRate } from "../../model/exchange-rate";
import { Observable, of, Subscription } from "rxjs";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnDestroy {

  subscriptionExchangeRateList: Subscription;

  exchangeRateList$: Observable<ExchangeRate[]>;

  constructor(private exchangeRateService: ExchangeServiceService) {
    this.subscriptionExchangeRateList = exchangeRateService.list().subscribe((data: ExchangeRate[])  => {
      this.exchangeRateList$ = of(data);
    });
  }

  ngOnDestroy(): void {
    if(this.subscriptionExchangeRateList) {
      this.subscriptionExchangeRateList.unsubscribe();
    }
  }

}
