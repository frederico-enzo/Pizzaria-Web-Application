import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {
  API: string = 'http://localhost:8080/enderecos';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Endereco[]> {
    return this.http.get<Endereco[]>(this.API);
  }

  create(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(this.API, endereco);
  }
  update(endereco:Endereco, id: Number):Observable<Endereco>{
    return this.http.put<Endereco>(this.API+"/"+id, endereco);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
