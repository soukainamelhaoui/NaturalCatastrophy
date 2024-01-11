import { Component, OnInit } from '@angular/core';
import { Stock } from '../interfaces/stock';
import { DonateService } from 'src/app/services/donate.service';

interface Column {
  field: string;
  header: string;
}
@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {
  Stocks: Stock[] = [];

  constructor(private donateservice: DonateService) {}

  ngOnInit() {
    this.getAllDonations();
  }

  getAllDonations() {
    this.donateservice.getAllDonations().subscribe(
      (res: Stock[]) => {
        this.Stocks = res;
        console.log("All donations", res);
      },
      (error) => {
        console.error('Error loading all donation data:', error);
      }
    );
  }
}