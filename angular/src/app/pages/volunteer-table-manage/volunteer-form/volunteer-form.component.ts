import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { VolunteersService } from 'src/app/services/volunteers.service';

@Component({
  selector: 'app-volunteer-form',
  templateUrl: './volunteer-form.component.html',
  styleUrls: ['./volunteer-form.component.scss']
})
export class VolunteerFormComponent {
  value!: string;
  date1: Date | undefined;
  ingredient!: string;
  selectedRole: any = null;
  selectedAgency: any = null;
  volunteerForm!:FormGroup;
  isLoading: boolean = false;
  erromessages:Array<string>=[]

  dropdownItems = [
    { name: 'Driver', code: 'Driver' },
    { name: 'distributer', code: 'distributer' },
    { name: 'organizer', code: 'organizer' }
];

dropdownItems2 = [
  { name: 'Agency1', code: 'Agency1' },
  { name: 'Agency2', code: 'Agency2' },
  { name: 'Agency3', code: 'Agency3' }
];

  
  constructor(private fb: FormBuilder,private VolunteersService:VolunteersService, private router: Router) {
    this.createForm();
  
  }



createForm() {
  this.volunteerForm = this.fb.group({
    username:['',  Validators.required],
    firstName:['',  Validators.required],
    lastName:['',  Validators.required],
    agence:['',  Validators.required],
    role:['',  Validators.required],
    phone:['',  Validators.required],
  });}
 
     save() {
    console.log('volunteerForm:', this.volunteerForm.value);
    if(this.volunteerForm.valid) {
      this.isLoading = true;
       this.VolunteersService.volunteer( this.volunteerForm.value).subscribe( (res) => {
          console.log("donate Res:", res);
          this.VolunteersService.sendMessage('thank you for your participation ');
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
