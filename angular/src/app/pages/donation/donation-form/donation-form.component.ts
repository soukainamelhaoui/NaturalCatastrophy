import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { DonateService } from 'src/app/services/donate.service';

@Component({
  selector: 'app-donation-form',
  templateUrl: './donation-form.component.html',
  styleUrls: ['./donation-form.component.scss']
})
export class DonationFormComponent {
  selectedDonation: string;
  DonateForm!:FormGroup;
  isLoading: boolean = false;
  erromessages:Array<string>=[]


  constructor(private fb: FormBuilder,private donateservice:DonateService, private router: Router) {
    this.createForm();
    this.selectedDonation='';
  }
  
  dropdownItems = [
    { name: 'clothes', code: 'clothes' },
    { name: 'Food', code: 'Food' },
    { name: 'books ', code: 'books ' },
    { name: ' Hygiene-Products', code: 'Hygiene-Products' },
    { name: 'School-Supplies', code: 'SchoolSupplies' },
    { name: 'Medical-Supplies', code: 'Medical-Supplies' },
];

  createForm() {
    this.DonateForm = this.fb.group({
      description:['',  Validators.required],
      type:['',  Validators.required],
      quantity:['',  Validators.required],
      donatorUsername:['',  Validators.required],
    });
   
      this.DonateForm.get("type")?.valueChanges.subscribe((value) => {
        this.selectedDonation=value;
      });
 
  }
  
  
  save() {
    console.log('DonateForm:', this.DonateForm.value);
    if(this.DonateForm.valid) {
      this.isLoading = true;
       this.donateservice.donateall( this.DonateForm.value).subscribe( (res) => {
          console.log("donate Res:", res);
          this.donateservice.sendMessage('thank you for your donation ');

          this.router.navigate(['../donation']);
      },
      (error) => {
        this.isLoading = false;
        this.erromessages=error.error.validationErrors;
        console.log(this.erromessages);
       // console.error('Error register', error);
      });
    }
  }
  





}
