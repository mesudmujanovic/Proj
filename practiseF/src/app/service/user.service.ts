import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../constant/user';
import { environment } from '../../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

 private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  createUser(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user);
  }
}
