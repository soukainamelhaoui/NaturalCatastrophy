import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DonationRoutingModule } from './donation-routing.module';
import { DonationComponent } from './donation.component';
import { CarouselModule } from 'primeng/carousel';
import { ButtonModule } from 'primeng/button';
import { ToolbarModule } from 'primeng/toolbar';
import { AccordionModule } from 'primeng/accordion';
import { TabViewModule } from 'primeng/tabview';

import { DonationFormComponent } from './donation-form/donation-form.component';
import { DropdownModule } from "primeng/dropdown";
import { CheckboxModule } from 'primeng/checkbox';
import { PasswordModule } from 'primeng/password';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AutoCompleteModule } from "primeng/autocomplete";
import { CalendarModule } from "primeng/calendar";
import { ChipsModule } from "primeng/chips";
import { InputMaskModule } from "primeng/inputmask";
import { InputNumberModule } from "primeng/inputnumber";
import { CascadeSelectModule } from "primeng/cascadeselect";
import { MultiSelectModule } from "primeng/multiselect";
import { InputTextareaModule } from "primeng/inputtextarea";
import { InputTextModule } from 'primeng/inputtext';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

import { RadioButtonModule } from 'primeng/radiobutton';
import { MoneyFormComponent } from './money-form/money-form.component';
@NgModule({
  
  declarations: [
    DonationComponent,
    DonationFormComponent,
    MoneyFormComponent,
    
  ],
  imports: [
    CommonModule,
    DonationRoutingModule,
    CarouselModule,
    ButtonModule,
    FormsModule,
    ToolbarModule,
    AccordionModule,
    TabViewModule,
    CheckboxModule,
    MultiSelectModule,
    PasswordModule,
    ButtonModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    CalendarModule,
    InputTextareaModule,
    InputMaskModule,
    InputTextModule,
    CascadeSelectModule,
    ChipsModule,
    RadioButtonModule,
    InputNumberModule,
    DropdownModule,
    MessagesModule,
    MessageModule,
    ToastModule
    
  ],
  providers:[MessageService]
})
export class DonationModule { }
