import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {RegisterPayload} from '../../modules/register-payload';
import {LoginPayload} from '../../modules/login-payload';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  registerPayload: RegisterPayload;
  loginPayload: LoginPayload;

  constructor(private formBuilder: FormBuilder, private authService: AuthService, private router: Router) {
    this.registerForm = this.formBuilder.group({
      username: '',
      secondName: '',
      email: '',
      password: '',
      confirmPassword: ''
    });
    this.registerPayload = {
      name: '',
      secondName: '',
      email: '',
      password: '',
      confirmPassword: ''
    };
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.registerPayload.name = this.registerForm.get('username').value;
    this.registerPayload.secondName = this.registerForm.get('secondName').value;
    this.registerPayload.email = this.registerForm.get('email').value;
    this.registerPayload.password = this.registerForm.get('password').value;
    this.registerPayload.confirmPassword = this.registerForm.get('confirmPassword').value;

    this.authService.register(this.registerPayload).subscribe(data => {
      console.log('register success');
      this.router.navigateByUrl('/login');
    }, error => {
      console.log('register failed');
    });
  }
}
