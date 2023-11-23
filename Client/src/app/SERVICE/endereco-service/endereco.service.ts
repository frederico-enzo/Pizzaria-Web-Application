import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {
  API: string = 'http://localhost:8080/endereços';
  http = inject(HttpClient);

  constructor() { }

  findById(id: Number): Observable<Endereco> {
    return this.http.delete<Endereco>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<Endereco[]> {
    return this.http.get<Endereco[]>(this.API + "/findAll");
  }
  post(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(this.API + "/create", endereco);
  }
  put(endereco: Endereco, id: Number): Observable<Endereco> {
    return this.http.put<Endereco>(this.API + "/update?id=" + id, endereco);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  }
}
