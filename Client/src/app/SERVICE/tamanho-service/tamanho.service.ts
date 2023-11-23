import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Tamanho } from 'src/app/MODEL/tamanho-model/tamanho';

@Injectable({
  providedIn: 'root'
})
export class TamanhoService {
  API: string = 'http://localhost:8080/propriedades';
  http = inject(HttpClient);

  constructor() { }

  findById(id: Number): Observable<Tamanho> {
    return this.http.delete<Tamanho>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<Tamanho[]> {
    return this.http.get<Tamanho[]>(this.API + "/findAll");
  }
  post(tamanho: Tamanho): Observable<Tamanho> {
    return this.http.post<Tamanho>(this.API + "/create", tamanho);
  }
  put(tamanho: Tamanho, id: Number): Observable<Tamanho> {
    return this.http.put<Tamanho>(this.API + "/update?id=" + id, tamanho);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  }
}