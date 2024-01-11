import { Component, OnInit } from '@angular/core';
import { DonateService } from 'src/app/services/donate.service';
import { money } from '../../interfaces/stock';
import { Subject, takeUntil } from 'rxjs';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-items-money',
  templateUrl: './items-money.component.html',
  styleUrls: ['./items-money.component.scss']
})
export class ItemsMoneyComponent implements OnInit {
  allmoney: money[] = [];
  MoneyBalance!: any;

  constructor( private MessageService:MessageService, private donateservice: DonateService) {}
  
  
  
  ngOnInit(): void {
    this.getAllMoneyDonation();
    this.getMoneyBalance();
  }

  

  getAllMoneyDonation() {
    this.donateservice.getMoneyDonation().subscribe(
      (res: money[]) => {
        this.allmoney = res;
        console.log("All money", res);
      },
      (error) => {
        console.error('Error loading all money data:', error);
      }
    );
  }

  getMoneyBalance() {
    this.donateservice.getMoneyBalance().subscribe(
      (res: number) => {
        this.MoneyBalance = res;
        console.log(" money", res);
      },
      (error) => {
        console.error('Error loading  money balance:', error);
      }
    );
  }

 




}
