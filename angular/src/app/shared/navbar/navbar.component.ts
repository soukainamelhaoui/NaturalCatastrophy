import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  constructor(private router: Router){}
  tieredItems: MenuItem[] = [];

  ngOnInit(): void {
    this.tieredItems = [
      {
          label: 'Volunteer',
          icon: 'pi pi-fw pi-table',
         
          items: [
              {
                  label: 'tasks',
                  icon: 'pi pi-fw pi-plus',
                  routerLink:'contribution',
              },
              {
                  label: 'Find Your Perfect Fit',
                  icon: 'pi pi-search',
                  routerLink:'volunteers-table/form',

              },
              {
                label: 'Volunteers List',
                icon: 'pi pi-search',
                routerLink:'volunteers-table',

            }
          ]
      },
      {
          label: 'Give Blood',
          icon: 'pi pi-shield',
          routerLink:'blood',
      },
      {
        label: 'Urgently Needed',
        icon: 'pi pi-exclamation-triangle',
        routerLink:'donation',
    },

      {
          label: 'Stock',
          icon: 'pi pi-fw pi-compass',
          routerLink:'items',
          items: [
            {
                label: 'Money',
                icon: 'pi pi-fw pi-plus',
                routerLink:'items/money',
            },
       
        ]

      },
      {
        label: 'FAQ',
        icon: 'pi pi-question-circle',
        routerLink:'FAQ',
    
    },
    {
      label: 'About Us',
      icon: 'pi pi-fw pi-user',
      routerLink:'about-us',
  },
    {label: '',icon: '',},{label: '',icon: '',},{label: '',icon: '',},{label: '',icon: '',},{label: '',icon: '',},{label: '',icon: '',},{label: '',icon: '',},
      
      

      {
          label: 'Profile',
          icon: 'pi pi-fw pi-user',
          
      },
      { separator: true },
      {
          label: 'Quit',
          icon: 'pi pi-fw pi-sign-out'
      }
  ];
  }

}
