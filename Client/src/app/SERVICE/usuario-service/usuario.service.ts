import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/MODEL/user-model/user';
@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  API: string = 'http://localhost:8080/usuarios';
  http = inject(HttpClient);

  constructor() { }

  findById(id: Number): Observable<User> {
    return this.http.delete<User>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<User[]> {
    return this.http.get<User[]>(this.API + "/findAll");
  }
  post(user: User): Observable<User> {
    return this.http.post<User>(this.API + "/create", user);
  }
  put(user: User, id: Number): Observable<User> {
    return this.http.put<User>(this.API + "/update?id=" + id, user);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  }
}
