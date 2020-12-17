import { FirstServiceService } from './services/first-service.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { SecondComponent } from './components/second/second.component';
import { ThirdComponent } from './components/third/third.component';
import { BestAllComponent } from './components/bestall/bestall.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    SecondComponent,
    ThirdComponent,
    BestAllComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [FirstServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
