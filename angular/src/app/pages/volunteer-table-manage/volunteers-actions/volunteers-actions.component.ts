import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ICellRendererAngularComp } from 'ag-grid-angular';
import { ConfirmEventType, ConfirmationService, MessageService } from 'primeng/api';
import { VolunteersService } from 'src/app/services/volunteers.service';
import { ICellRendererParams } from 'ag-grid-community';

@Component({
  selector: 'app-volunteers-actions',
  templateUrl: './volunteers-actions.component.html',
  styleUrls: ['./volunteers-actions.component.scss']
})
export class VolunteersActionsComponent implements  ICellRendererAngularComp , OnInit {
  checked: boolean = false;
  data: any;
  id:any;
  items: any[] = [

    {
      id: 'supprimer',
      name: 'Supprimer',
      icon: 'pi pi-trash',
      class: 'p-button-rounded p-button-danger p-button-text mr-2 mb-2',
    },
  ];


  constructor( private router: Router,private VolunteersService:VolunteersService,
    private messageService: MessageService, private confirmationService: ConfirmationService) {}
  
  agInit(params: ICellRendererParams<any, any>): void {
    this.data = params.data;
    if(this.data.isVerified){this.checked=true}
    // this.cellValue = params.valueFormatted
    //   ? params.valueFormatted
    //   : params.value;
  }
  refresh(params: ICellRendererParams<any, any, any>): boolean {
   return true;
  }

  ngOnInit(): void {

  }

  changeUserState(VolunteerActive:boolean, id:number){

    
  if(VolunteerActive){this.VolunteersService.ValidateVolunteerById(this.data.id).subscribe({
    next:()=>{            
      window.location.reload();
    }
    
  });
  }
   else{
    {this.VolunteersService.InValidateVolunteerById(this.data.id).subscribe({
      next:()=>{            
          window.location.reload();
      }
    });
    }
   }
  }


  selectOption(selected: string) {
  
    if (selected == 'supprimer') {
      console.log("data:", this.data.id);
      this.confirmationService.confirm({
        message: 'Are you sure that you want to proceed?',
        icon: 'pi pi-exclamation-triangle',
        accept: () => {
         
            this.VolunteersService.Delete(this.data.id).subscribe(
              (res) => {
                if(res){
                  this.messageService.add({ severity: 'info', summary: 'Info', detail: 'volunteer has been deleted'});
                  setTimeout(() => {
                    window.location.reload();
                  }, 1000);

                }

              },
              (error) => {
                console.error('Error delete User data:', error);
              }
            );
          
        },
        reject: (type: ConfirmEventType) => {
            switch (type) {
                case ConfirmEventType.REJECT:
                    this.messageService.add({ severity: 'error', summary: 'Rejected', detail: 'You have rejected' });
                    break;
                case ConfirmEventType.CANCEL:
                    this.messageService.add({ severity: 'warn', summary: 'Cancelled', detail: 'You have cancelled' });
                    break;
            }
        }
    });

    }
  }
}
