import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./component/home/home.component";
import { CalculateComponent } from "./component/calculate/calculate.component";
import { UpdateComponent } from "./component/update/update.component";

const routes: Routes = [
  {
    path: "home", component: HomeComponent
  },
  {
    path: "calculate", component: CalculateComponent
  },
  {
    path: "update", component: UpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
