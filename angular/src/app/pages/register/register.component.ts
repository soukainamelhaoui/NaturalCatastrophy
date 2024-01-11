import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
RegisterForm!:FormGroup;
isLoading: boolean = false;
erromessages:Array<string>=[]
constructor(private fb: FormBuilder,private authservice:AuthService, private router: Router) {
  this.createForm();
}

createForm() {
  this.RegisterForm = this.fb.group({
    username:['',  Validators.required],
    firstName:['',  Validators.required],
    lastName:['',  Validators.required],
    address:['',  Validators.required],
    phone:['', Validators.required],
  });
}


register() {
  console.log('registerForm:', this.RegisterForm.value);
  if(this.RegisterForm.valid) {
    this.isLoading = true;
     this.authservice.register( this.RegisterForm.value).subscribe( (res) => {
        console.log("register Res:", res);
        this.router.navigate(['../home']);
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
