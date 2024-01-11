import { Component, OnInit } from '@angular/core';
import { volunteer } from '../interfaces/volunteer';
import { VolunteersService } from 'src/app/services/volunteers.service';
import {   ColDef, GridOptions, IMultiFilterParams, ITextFilterParams } from 'ag-grid-community';
import { VolunteersActionsComponent } from './volunteers-actions/volunteers-actions.component';

@Component({
  selector: 'app-volunteer-table-manage',
  templateUrl: './volunteer-table-manage.component.html',
  styleUrls: ['./volunteer-table-manage.component.scss']
})
export class VolunteerTableManageComponent implements OnInit {
  showInactiveVolunteersOnly: boolean = false;

  allVolunteers :Array<volunteer>= [ ];
  constructor(  private VolunteersService: VolunteersService) {}
  ngOnInit(): void {
    this.getAllVolunteers();
  }

  gridOptions: GridOptions = {
    columnDefs : [
      { field: 'username',width: 180 },
      { field: 'firstName',width: 180 },
      { field: 'lastName',width: 250 },
      { field: 'agence' ,width: 300 },
       { field: 'role' ,width: 150,},
       { field: 'phone' ,width: 150,},
      { field: 'Actions' ,width: 300, cellRenderer:VolunteersActionsComponent },

  ],
  defaultColDef: {
    editable: true,
    minWidth: 100,
    flex: 1,
    resizable: true,

  }

}

  
  getAllVolunteers() {
    this.VolunteersService.getAllVolunteers().subscribe(
      (res: volunteer[]) => {
        this.allVolunteers = res;
        console.log("All volunteers", res);
      },
      (error) => {
        console.error('Error loading all money data:', error);
      }
    );
  }

  filterCustomers(){
    if(this.showInactiveVolunteersOnly){
     this.allVolunteers=this.allVolunteers.filter((c)=>!c.isVerified)
    }else{
   
     this.getAllVolunteers();
    }
   
   }






}
