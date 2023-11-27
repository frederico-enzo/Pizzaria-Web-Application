import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';

@Injectable({
  providedIn: 'root'
})
export class AtributoService {
  API: string = 'http://localhost:8080/atributos';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Atributo[]> {
    return this.http.get<Atributo[]>(this.API);
  }
  create(atributo: Atributo): Observable<Atributo> {
    return this.http.post<Atributo>(this.API, atributo);
  }
  update(atributo:Atributo, id: Number):Observable<Atributo>{
    return this.http.put<Atributo>(this.API+"/"+id, atributo);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
