import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Demanda } from 'src/app/MODEL/demanda-model/demanda';
@Injectable({
  providedIn: 'root'
})
export class DemandaService {

  API: string = 'http://localhost:8080/demandas';
  http = inject(HttpClient);

  constructor() { }

  findById(id: Number): Observable<Demanda> {
    return this.http.delete<Demanda>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<Demanda[]> {
    return this.http.get<Demanda[]>(this.API + "/findAll");
  }
  post(demanda: Demanda): Observable<Demanda> {
    return this.http.post<Demanda>(this.API + "/create", demanda);
  }
  put(demanda: Demanda, id: Number): Observable<Demanda> {
    return this.http.put<Demanda>(this.API + "/update?id=" + id, demanda);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  }
}
