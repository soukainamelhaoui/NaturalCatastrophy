import { Component, OnInit } from '@angular/core';
import { contribution } from '../interfaces/contribution';
import { ContributionService } from 'src/app/services/contribution.service';
import {   ColDef, GridOptions, IMultiFilterParams, ITextFilterParams } from 'ag-grid-community';
import { ContributionActionsComponent } from './contribution-actions/contribution-actions.component';

@Component({
  selector: 'app-contributions',
  templateUrl: './contributions.component.html',
  styleUrls: ['./contributions.component.scss']
})

export class ContributionsComponent implements OnInit {
  showInactiveVolunteersOnly: boolean = false;

  allContributions :Array<contribution>= [ ];
  constructor(  private ContributionService: ContributionService) {}
  ngOnInit(): void {
    this.getAllContribution();
  }

  gridOptions: GridOptions = {
    columnDefs : [
      { field: 'name',width: 150 },
      { field: 'departureDate',width: 150 },
      { field: 'departureCity',width: 150 },
      { field: 'vehicle' ,width: 150 },
       { field: 'city' ,width: 150,},
       { field: 'itemNames' ,width: 300,},
       { field: 'volunteers' ,width: 300,  valueGetter: function (params) {
        // Utilisez valueGetter pour extraire les noms d'utilisateur des volontaires
        return params.data.volunteers.map((volunteer: { username: any; }) => volunteer.username).join(', ');
      },},
      { field: 'Actions' ,width: 300, cellRenderer:ContributionActionsComponent },
  
  ],
  defaultColDef: {
    editable: true,
    minWidth: 100,
    flex: 1,
    resizable: true,

  }

}

  
  getAllContribution() {
    this.ContributionService.getAllContributions().subscribe(
      (res: contribution[]) => {
        this.allContributions = res;
        console.log("All Contributions", res);
      },
      (error) => {
        console.error('Error loading all money data:', error);
      }
    );
  }

  filterCustomers(){
    if(this.showInactiveVolunteersOnly){
     this.allContributions=this.allContributions.filter((c)=>!c.isDone)
    }else{
   
     this.getAllContribution();
    }
   
   }






}
