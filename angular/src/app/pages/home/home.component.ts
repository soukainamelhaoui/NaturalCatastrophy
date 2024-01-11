import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  catastrophe: any[] = [
    { name: 'SUPPORT PEOPLE IN GAZA', image: '1.jpg' },
    { name: 'DONATE FOR GAZA CHILDREN', image: '2.jpg' },
    { name: 'WE ARE ALL JOINED BY BLOOD', image: '10.jpg' },
    { name: ' DONATE YOUR VEHICLE AND BRING HELP AND HOPE TO THOSE IN NEED', image: '7.jpg' },
    { name: 'SUPPORT PEOPLE IN PALESTINE', image: '8.jpg' },
    { name: 'DONATE FOR GAZA CHILDREN', image: '9.jpg' },
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
}
