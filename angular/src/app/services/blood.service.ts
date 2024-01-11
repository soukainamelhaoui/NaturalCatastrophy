import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { donateBlood } from '../pages/interfaces/blood';

@Injectable({
  providedIn: 'root'
})
export class BloodService {

  private BloodBehavior = new BehaviorSubject<any>(null);


  constructor(private httpclient:HttpClient) { }
  private baseUrl = 'http://localhost:80/donation/api/donation/blood/save';

  private headers: HttpHeaders = new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:80',
  });

  donateBlood(input:donateBlood): Observable<any> {
    return this.httpclient.post(`${this.baseUrl}`, input, { headers: this.headers });
  }

  getMessage(): Observable<any> {
    return this.BloodBehavior.asObservable();
  }

  sendMessage(message: string) {
    this.BloodBehavior.next(message);
  }
}
