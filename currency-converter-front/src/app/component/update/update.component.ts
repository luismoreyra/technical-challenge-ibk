import {Component, OnDestroy, OnInit} from '@angular/core';
import { Observable, of, Subscription } from "rxjs";
import { ExchangeRate } from "../../model/exchange-rate";
import { FormControl, FormGroup } from "@angular/forms";
import { ExchangeServiceService } from "../../service/exchange-service.service";
import { UpdateExchangeRateRequest } from 'src/app/model/update-exchange-rate-request';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnDestroy {

  subscriptionExchangeRateList: Subscription;
  subscriptionUpdateExchangeRate: Subscription;

  exchangeRateList$: Observable<ExchangeRate[]>;
  exchangeRateList: ExchangeRate[];
  updateExchangeRateRequest: UpdateExchangeRateRequest;

  updateExchangeRateForm = new FormGroup({
    code: new FormControl(""),
    rate: new FormControl('')
  })

 constructor(private exchangeRateService: ExchangeServiceService) {
   this.subscriptionExchangeRateList = this.exchangeRateService.list().subscribe((data: ExchangeRate[])  => {
     this.exchangeRateList$ = of(data);
     this.exchangeRateList = data;
   });
 }

  ngOnDestroy(): void {
    if(this.subscriptionExchangeRateList) {
      this.subscriptionExchangeRateList.unsubscribe();
    }
    if(this.subscriptionExchangeRateList) {
      this.subscriptionExchangeRateList.unsubscribe();
    }
  }

  update() {
    this.subscriptionUpdateExchangeRate = this.exchangeRateService.update(this.updateExchangeRateForm.value).subscribe(data => {
      this.exchangeRateList.filter(exchangeRate => exchangeRate.code == data.code)[0].rate = data.rate;
      this.updateExchangeRateForm.patchValue({
        code: '',
        rate: ''
      });
      alert("Se actualizó tipo de cambio correctamente.");
    })
  }

  selectExchangeRate(e: any) {
    let selectedUpdateExchangeRate = this.exchangeRateList.filter(exchangeRate => exchangeRate.code == e.target.value)[0];
    this.updateExchangeRateForm.controls.rate.patchValue(selectedUpdateExchangeRate.rate);
  }

}
