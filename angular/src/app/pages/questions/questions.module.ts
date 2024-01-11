import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuestionsRoutingModule } from './questions-routing.module';
import { QuestionsComponent } from './questions.component';
import { AccordionModule } from 'primeng/accordion';
import { RippleModule } from 'primeng/ripple';


@NgModule({
  declarations: [
    QuestionsComponent
  ],
  imports: [
    CommonModule,
    QuestionsRoutingModule,
    AccordionModule,
    RippleModule
  ]
})
export class QuestionsModule { }
