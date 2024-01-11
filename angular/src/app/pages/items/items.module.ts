import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItemsRoutingModule } from './items-routing.module';
import { ItemsComponent } from './items.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { ItemsMoneyComponent } from './items-money/items-money.component';
import { MessagesModule } from 'primeng/messages';
import { MessageModule } from 'primeng/message';
import { ToastModule } from 'primeng/toast';
import { MessageService } from 'primeng/api';

import { RadioButtonModule } from 'primeng/radiobutton';

@NgModule({
  declarations: [
    ItemsComponent,
    ItemsMoneyComponent
  ],
  imports: [
    CommonModule,
    ItemsRoutingModule,
    TableModule,
    ButtonModule,
    MessagesModule,
    MessageModule,
    ToastModule
    
    
  ],
  providers:[MessageService]
})
export class ItemsModule { }
