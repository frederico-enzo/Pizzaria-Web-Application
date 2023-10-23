import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';

@Injectable({
  providedIn: 'root'
})
export class SaborService {

  API: string = 'http://localhost:8080/sabores';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Sabor[]> {
    return this.http.get<Sabor[]>(this.API);
  }

  create(sabor: Sabor): Observable<Sabor> {
    return this.http.post<Sabor>(this.API, sabor);
  }
  update(sabor:Sabor, id: Number):Observable<Sabor>{
    return this.http.put<Sabor>(this.API+"/"+id, sabor);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
