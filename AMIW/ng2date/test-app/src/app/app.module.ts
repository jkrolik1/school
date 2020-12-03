import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TodoService } from './todo.service';
import { ItemComponent } from './item/item.component'

@NgModule({
  declarations: [
    AppComponent,
    ItemComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    BrowserModule
  ],
  providers: [
    TodoService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
