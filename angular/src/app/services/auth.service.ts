import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { registerI } from '../pages/interfaces/auth.interface';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpclient:HttpClient) { }
  private baseUrl = 'http://localhost:80/donation/api/donation/donator/save';

  private headers: HttpHeaders = new HttpHeaders({
     'Access-Control-Allow-Origin': 'http://localhost:80',
   });

  register(input: registerI): Observable<any> {
     return this.httpclient.post<any>(`${this.baseUrl}`, input, { headers: this.headers });
  }
}