import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private apiurl="assets/booklist.json";
  constructor(private http:HttpClient) {    }
  getBookList(){
    return this.http.get(this.apiurl);
  }
}
