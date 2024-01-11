import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { volunteer } from '../pages/interfaces/volunteer';
import { BehaviorSubject, Observable } from 'rxjs';
import { contribution } from '../pages/interfaces/contribution';

@Injectable({
  providedIn: 'root'
})
export class ContributionService {


  private ContributionBehavior = new BehaviorSubject<any>(null);


  constructor(private httpclient:HttpClient) { }
  private baseUrl = 'http://localhost:80/volunteering/api/volunteering/distribution/save';
  private baseUrl1 = 'http://localhost:80/volunteering/api/volunteering/distribution/all';
  private baseUrl2 = 'http://localhost:80/volunteering/api/volunteering/distribution/done';
  private baseUrl3 = 'http://localhost:80/volunteering/api/volunteering/distribution/undone';
  private baseUrl4 = 'http://localhost:80/volunteering/api/volunteering/distribution/delete';

  private headers: HttpHeaders = new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:80',
  });

  contibutionSave(input:contribution): Observable<any> {
    return this.httpclient.post(`${this.baseUrl}`, input, { headers: this.headers });
  }

  getAllContributions(): Observable<any> {
    return this.httpclient.get(`${this.baseUrl1}`, { headers: this.headers });

  }
  taskFinished(id:number): Observable<any> {
    return this.httpclient.put<any>(`${this.baseUrl2}/${id}`,null, { headers: this.headers });
  }
  taskUnfinished(id:number): Observable<any> {
    return this.httpclient.put<any>(`${this.baseUrl3}/${id}`,null, { headers: this.headers });
  }

  Delete(id:number): Observable<any> {
    return this.httpclient.delete<any>(`${this.baseUrl4}/${id}`, { headers: this.headers });
  }
  getMessage(): Observable<any> {
    return this.ContributionBehavior.asObservable();
  }

  sendMessage(message: string) {
    this.ContributionBehavior.next(message);
  }


}
