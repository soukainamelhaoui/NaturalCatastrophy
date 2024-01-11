import { Component, OnDestroy } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Subject, takeUntil } from 'rxjs';
import { DonateService } from 'src/app/services/donate.service';
import { VolunteersService } from 'src/app/services/volunteers.service';

@Component({
  selector: 'app-donation',
  templateUrl: './donation.component.html',
  styleUrls: ['./donation.component.scss']
})
export class DonationComponent implements OnDestroy {

  private unSub$ = new Subject<void>();

  constructor( private MessageService:MessageService, private donateservice: DonateService,private VolunteersService:VolunteersService) {}

  folders: any = [
    { name: 'Produit 1' },
    { name: 'Produit 1'},
    { name: 'Produit 1' },
    { name: 'Produit 1' },
    { name: 'Produit 1' },
    { name: 'Produit 1' },
    { name: 'Produit 1' },
    { name: 'Produit 1' },
    { name: 'Produit 1' },


  ];
  besoin: any[] = [
    { name: 'Money', image: '14.jpg' },
    { name: 'Food', image: '18.jpg' },
    { name: 'clothes', image: '3.jpg' },
    { name: 'Medicine', image: '5.jpg' },
    { name: 'Trucks', image: '4.jpg' },
    { name: 'volunteers', image: '1.png' },
  ];

  help: any[] = [
    { name: 'Volunteer',image: '20.jpg' },
    { name: 'Donate Blood', image: '15.jpg' },
    { name: 'Share on Social Media', image: '19.jpg' },

  ];
  carouselResponsiveOptions: any[] = [
    {
        breakpoint: '1024px',
        numVisible: 3,
        numScroll: 3
    },
    {
        breakpoint: '768px',
        numVisible: 2,
        numScroll: 2
    },
    {
        breakpoint: '560px',
        numVisible: 1,
        numScroll: 1
    }
];

ngAfterViewInit(): void {
  setTimeout(() => {
    this.donateservice
    //this.VolunteersService
    .getMessage()
    .pipe(takeUntil(this.unSub$))
    .subscribe((message) => {
     
      if (message.trim() !== '') {
        // Vérifiez si le message n'est pas vide avant d'ajouter le toast
        this.MessageService.add({ severity: 'success', summary: 'Success', detail: message });
      }
      
    });
  },1);

}

ngOnDestroy(): void {
this.unSub$.unsubscribe();}


}
