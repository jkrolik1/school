import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DateComponent } from '../app/date/date.component';
import { MathComponent } from '../app/math/math.component';
import { TriviaComponent } from '../app/trivia/trivia.component';
import { YearComponent } from '../app/year/year.component';

const routes: Routes = [
  { path: 'date-facts', component: DateComponent },
  { path: 'math-facts', component: MathComponent },
  { path: 'trivia-facts', component: TriviaComponent },
  { path: 'year-facts', component: YearComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
