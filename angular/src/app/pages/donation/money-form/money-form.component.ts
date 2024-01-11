import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Subject, takeUntil } from 'rxjs';
import { DonateService } from 'src/app/services/donate.service';

@Component({
  selector: 'app-money-form',
  templateUrl: './money-form.component.html',
  styleUrls: ['./money-form.component.scss']
})
export class MoneyFormComponent {
  private unSub$ = new Subject<void>();

  DonateMoneyForm!:FormGroup;
  isLoading: boolean = false;
  erromessages:Array<string>=[]
  constructor(private fb: FormBuilder,private donateservice:DonateService, private router: Router,private MessageService:MessageService) {
    this.createForm();
  }
  
  createForm() {
    this.DonateMoneyForm = this.fb.group({
      amount:['',  Validators.required],
      donatorUsername:['',  Validators.required],
      comment:['',  Validators.required],
    });
  }
  
  
  save() {
    console.log('DonateMoneyForm:', this.DonateMoneyForm.value);
    if(this.DonateMoneyForm.valid) {
      this.isLoading = true;
       this.donateservice.donateMoney( this.DonateMoneyForm.value).subscribe( (res) => {
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
