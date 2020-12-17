import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { ThirdComponent } from './components/third/third.component';
import { BestAllComponent } from './components/bestall/bestall.component';

const routes: Routes = [
  { path: 'the-best-today-animals', component: FirstComponent },
  { path: 'the-best-today-blonde', component: SecondComponent },
  { path: 'the-best-today-knockknock', component: ThirdComponent },
  { path: 'the-best-today', component: BestAllComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
