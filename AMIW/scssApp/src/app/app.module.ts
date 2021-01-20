import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DateComponent } from './date/date.component';
import { AppRoutingModule } from './app-routing.module';
import { MathComponent } from './math/math.component';
import { TriviaComponent } from './trivia/trivia.component';
import { YearComponent } from './year/year.component';

@NgModule({
  declarations: [
    AppComponent,
    DateComponent,
    MathComponent,
    TriviaComponent,
    YearComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
