import { HttpClient } from '@angular/common/http';
import { Token } from '@angular/compiler';
import { Injectable, inject } from '@angular/core';

import { Observable } from 'rxjs';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { Login } from 'src/app/MODEL/login-model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  API: string = "http://localhost:8080/api/login"
  http = inject(HttpClient);

  constructor() { }

  logar(login: Login): Observable<Cliente> {
    return this.http.post<Cliente>(this.API, login)
  }

  deslogar(login: Login): Observable<any> {
    return this.http.get<any>(this.API + "/deslogar")
  }

  addToken(token: string){
    localStorage.setItem("token", token);
  }

  removeToken(){
    localStorage.removeItem("token");
  }

  getToken(){
    return localStorage.getItem("token");
  }

  
  hasPermission(role: string){
    if(role == "ADMIN"){
      return true;
    } else{
      return false;
    }
  }
}