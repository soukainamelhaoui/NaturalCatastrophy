import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { BloodRoutingModule } from './blood-routing.module';
import { BloodComponent } from './blood.component';
import { BloodInstructionComponent } from './blood-instruction/blood-instruction.component';
import { BloodFormComponent } from './blood-form/blood-form.component';
import { DropdownModule } from "primeng/dropdown";
import { CheckboxModule } from 'primeng/checkbox';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AutoCompleteModule } from "primeng/autocomplete";
import { CalendarModule } from "primeng/calendar";
import { ChipsModule } from "primeng/chips";
import { InputMaskModule } from "primeng/inputmask";
import { InputNumberModule } from "primeng/inputnumber";
import { CascadeSelectModule } from "primeng/cascadeselect";
import { MultiSelectModule } from "primeng/multiselect";
import { InputTextareaModule } from "primeng/inputtextarea";
import { RadioButtonModule } from 'primeng/radiobutton';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

@NgModule({
  declarations: [
    BloodComponent,
    BloodInstructionComponent,
    BloodFormComponent
  ],
  imports: [
    CommonModule,
    InputTextareaModule,
    BloodRoutingModule,
    DropdownModule,
    FormsModule,
    CheckboxModule,
    MultiSelectModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    ReactiveFormsModule,
    AutoCompleteModule,
    CalendarModule,
    InputMaskModule,
    CascadeSelectModule,
    ChipsModule,
    RadioButtonModule,
    InputNumberModule,
    MessagesModule,
    MessageModule,
    ToastModule
  ],
  providers: [ DatePipe,MessageService]
   
    
  
})
export class BloodModule { }
