import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Message, MessageService } from 'primeng/api';
import { BloodService } from 'src/app/services/blood.service';

@Component({
  selector: 'app-blood-form',
  templateUrl: './blood-form.component.html',
  styleUrls: ['./blood-form.component.scss']
})
export class BloodFormComponent {
  bloodType!: any;
  donationDate!: any ;
  lastdonationDate!: any ;
  selectedAgency: any = null;
  DonateBloodForm!:FormGroup;
  isLoading: boolean = false;
  erromessages:Array<string>=[]
  msgs: Message[] = [];
  constructor(private fb: FormBuilder, private  MessageService:MessageService ,private bloodService:BloodService, private router: Router,private datePipe: DatePipe) {
    this.createForm();
  }


dropdownItems = [
    { name: 'agency1', code: 'agency1 ' },
    { name: 'agency2', code: 'agency2' },
    { name: 'agency3', code: 'agency3' }
];
createForm() {
  this.DonateBloodForm = this.fb.group({
    bloodType:['',  Validators.required],
    city:['',  Validators.required],
    agency:['',  Validators.required],
    donationDate:['',  Validators.required],
   lastDonationDate:['',  Validators.required],
    donatorUsername:['',  Validators.required],
  });
 
//     this.DonateBloodForm.get("agency")?.valueChanges.subscribe((value) => {
//       this.selectedAgency=value;
//      });

}

formatToBackendDate(date: Date): string {
  return this.datePipe.transform(date, 'yyyy-MM-dd') || '';
}

save() {
  console.log('DonateForm:', this.DonateBloodForm.value);
  
  if (this.DonateBloodForm.valid) {
    this.isLoading = true;

    // Récupérez les valeurs du formulaire
    const formValues = this.DonateBloodForm.value;

    // Formatez les dates en utilisant DatePipe
    const formattedData = {
      ...formValues,
      donationDate: this.datePipe.transform(formValues.donationDate, 'yyyy-MM-dd') || '',
      lastDonationDate: this.datePipe.transform(formValues.lastDonationDate, 'yyyy-MM-dd') || ''
    };

    // Appelez le service pour effectuer la requête
    this.bloodService.donateBlood(formattedData).subscribe(
      (res) => {
        console.log("DonateBloodForm Res:", res);
       this.bloodService.sendMessage('thank you for your reservation');
       this.router.navigate(['../blood']);

        // Effectuez les opérations nécessaires après la sauvegarde réussie ici
      },
      (error) => {
        this.isLoading = false;
        this.erromessages = error.error.validationErrors;
        console.error('Error saving donation', error);
  
        // Ajoutez ici la logique de gestion des erreurs spécifique
      }
    );
  }
}



}



