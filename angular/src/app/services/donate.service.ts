import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { donateAll, donateMoney } from '../pages/interfaces/donate-money';

@Injectable({
  providedIn: 'root'
})
export class DonateService {

  private MoneyBehavior = new BehaviorSubject<any>(null);

  constructor(private httpclient:HttpClient) { }
  private baseUrl = 'http://localhost:80/donation/api/donation/money/save';
  private baseUrl2 = 'http://localhost:80/donation/api/donation/item/save';
  private baseUrl3 = 'http://localhost:80/donation/api/donation/item/all';
  private baseUrl4 = 'http://localhost:80/donation/api/donation/money/all';
  private baseUrl5 = 'http://localhost:80/donation/api/donation/money/total-money';

  private headers: HttpHeaders = new HttpHeaders({
    'Access-Control-Allow-Origin': 'http://localhost:80',
  });

  donateMoney(input:donateMoney): Observable<any> {
    return this.httpclient.post(`${this.baseUrl}`, input, { headers: this.headers });
  }
  donateall(input:donateAll): Observable<any> {
    return this.httpclient.post(`${this.baseUrl2}`, input, { headers: this.headers });
  }

  getAllDonations(): Observable<any> {
    return this.httpclient.get(`${this.baseUrl3}`, { headers: this.headers });

  }
  getMoneyDonation(): Observable<any> {
    return this.httpclient.get(`${this.baseUrl4}`, { headers: this.headers });

  }
  getMoneyBalance(): Observable<any> {
    return this.httpclient.get(`${this.baseUrl5}`, { headers: this.headers });

  }


  getMessage(): Observable<any> {
    return this.MoneyBehavior.asObservable();
  }

  sendMessage(message: string) {
    this.MoneyBehavior.next(message);
  }
}
