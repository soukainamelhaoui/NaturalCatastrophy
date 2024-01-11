import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { volunteer } from '../pages/interfaces/volunteer';

@Injectable({
  providedIn: 'root'
})
export class VolunteersService {

  private BloodBehavior = new BehaviorSubject<any>(null);


  constructor(private httpclient:HttpClient) { }
  private baseUrl = 'http://localhost:80/volunteering/api/volunteering/volunteer/save';
  private baseUrl1 = 'http://localhost:80/volunteering/api/volunteering/volunteer/all';
  private baseUrl2 = 'http://localhost:80/volunteering/api/volunteering/volunteer/verify';
  private baseUrl3 = 'http://localhost:80/volunteering/api/volunteering/volunteer/inverify';
  private baseUrl4 = 'http://localhost:80/volunteering/api/volunteering/volunteer/delete';

  private headers: HttpHeaders = new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:80',
  });

  volunteer(input:volunteer): Observable<any> {
    return this.httpclient.post(`${this.baseUrl}`, input, { headers: this.headers });
  }
  getAllVolunteers(): Observable<any> {
    return this.httpclient.get(`${this.baseUrl1}`, { headers: this.headers });

  }

  ValidateVolunteerById(id:number): Observable<any> {
    return this.httpclient.put<any>(`${this.baseUrl2}/${id}`,null, { headers: this.headers });
  }
  InValidateVolunteerById(id:number): Observable<any> {
    return this.httpclient.put<any>(`${this.baseUrl3}/${id}`,null, { headers: this.headers });
  }

  Delete(id:number): Observable<any> {
    return this.httpclient.delete<any>(`${this.baseUrl4}/${id}`, { headers: this.headers });
  }
  getMessage(): Observable<any> {
    return this.BloodBehavior.asObservable();
  }

  sendMessage(message: string) {
    this.BloodBehavior.next(message);
  }
}
