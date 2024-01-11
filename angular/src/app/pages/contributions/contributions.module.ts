import { NgModule } from '@angular/core';
import { CommonModule,DatePipe } from '@angular/common';

import { ContributionsRoutingModule } from './contributions-routing.module';
import { ContributionsComponent } from './contributions.component';
import { CreateContributionComponent } from './create-contribution/create-contribution.component';
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
import { AgGridModule } from 'ag-grid-angular';
import { PaginatorModule } from 'primeng/paginator';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { InputSwitchModule } from 'primeng/inputswitch';
import { ContributionActionsComponent } from './contribution-actions/contribution-actions.component';

@NgModule({
  declarations: [
    ContributionsComponent,
    CreateContributionComponent,
    ContributionActionsComponent
  ],
  imports: [
    CommonModule,
    ContributionsRoutingModule,
    AutoCompleteModule,
    CalendarModule,
    ChipsModule,
    InputMaskModule,
    InputNumberModule,
    CascadeSelectModule,
    FormsModule,
    ReactiveFormsModule,
    MultiSelectModule,
    InputTextareaModule,
    InputTextModule,
    MessagesModule,
    MessageModule,
    ToastModule,
    AgGridModule,
    PaginatorModule,
    ConfirmDialogModule,
    InputSwitchModule
    
  ],
  providers:[DatePipe,MessageService,ConfirmationService]
})
export class ContributionsModule { }
