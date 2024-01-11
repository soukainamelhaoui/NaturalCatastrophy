import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Subject, takeUntil } from 'rxjs';
import { BloodService } from 'src/app/services/blood.service';

@Component({
  selector: 'app-blood',
  templateUrl: './blood.component.html',
  styleUrls: ['./blood.component.scss']
})
export class BloodComponent  {

  private unSub$ = new Subject<void>();

  constructor(private bloodservice:BloodService ,private messageService: MessageService) {

  }

  ngAfterViewInit(): void {
    setTimeout(() => {
      this.bloodservice
        .getMessage()
        .pipe(takeUntil(this.unSub$))
        .subscribe((message) => {
          if (message.trim() !== '') {
            // Vérifiez si le message n'est pas vide avant d'ajouter le toast
            this.messageService.add({ severity: 'success', summary: 'Success', detail: message });
          }
        });
    }, 1);
  }


}
