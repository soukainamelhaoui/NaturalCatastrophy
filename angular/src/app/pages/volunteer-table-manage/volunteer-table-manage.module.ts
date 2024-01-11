import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VolunteerTableManageRoutingModule } from './volunteer-table-manage-routing.module';
import { VolunteerTableManageComponent } from './volunteer-table-manage.component';
import { VolunteersActionsComponent } from './volunteers-actions/volunteers-actions.component';
import { AgGridModule } from 'ag-grid-angular';
import { PaginatorModule } from 'primeng/paginator';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService, MessageService } from 'primeng/api';
import { InputSwitchModule } from 'primeng/inputswitch';
import { VolunteerFormComponent } from './volunteer-form/volunteer-form.component';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { DropdownModule } from "primeng/dropdown";
import { CheckboxModule } from 'primeng/checkbox';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { CalendarModule } from "primeng/calendar";
import { ChipsModule } from "primeng/chips";
import { InputMaskModule } from "primeng/inputmask";
import { InputNumberModule } from "primeng/inputnumber";
import { CascadeSelectModule } from "primeng/cascadeselect";
import { MultiSelectModule } from "primeng/multiselect";
import { InputTextareaModule } from "primeng/inputtextarea";
@NgModule({
  declarations: [
    VolunteerTableManageComponent,
    VolunteersActionsComponent,
    VolunteerFormComponent
  ],
  imports: [
    CommonModule,
    VolunteerTableManageRoutingModule,
    AgGridModule,
    PaginatorModule,
    ToastModule,
    ConfirmDialogModule,
    FormsModule,
    ReactiveFormsModule,
    InputSwitchModule,
    MessagesModule,
    MessageModule,
    DropdownModule,
    CheckboxModule,
    CalendarModule,
    ChipsModule,
    InputMaskModule,
    InputNumberModule,
    CascadeSelectModule,
    MultiSelectModule,
    InputTextareaModule
  ],
  providers: [MessageService,ConfirmationService],
})
export class VolunteerTableManageModule { }
