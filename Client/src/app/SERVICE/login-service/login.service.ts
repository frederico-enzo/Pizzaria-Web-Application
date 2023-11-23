import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from 'src/app/MODEL/login-model/login';
import { User } from 'src/app/MODEL/user-model/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  API: string = 'http://localhost:8080/auth/login';
  http = inject(HttpClient);

  constructor() { }


  logar(login: Login): Observable<User> {
    return this.http.post<User>(this.API, login);
  }

  deslogar(): Observable<any> {
    return this.http.get<any>(this.API+'/deslogar');
  }

  addToken(token: string){
    localStorage.setItem('token', token);
  }

  removerToken(){
    localStorage.removeItem('token');
  }

  getToken(){
    return localStorage.getItem('token');
  }
}
