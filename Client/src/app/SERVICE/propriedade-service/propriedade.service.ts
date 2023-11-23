import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Propriedade } from 'src/app/MODEL/propriedade-model/propriedade';

@Injectable({
  providedIn: 'root'
})
export class PropriedadeService {
  API: string = 'http://localhost:8080/propriedades';
  http = inject(HttpClient);

  constructor() { }

  findById(id: Number): Observable<Propriedade> {
    return this.http.delete<Propriedade>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<Propriedade[]> {
    return this.http.get<Propriedade[]>(this.API + "/findAll");
  }
  post(propriedade: Propriedade): Observable<Propriedade> {
    return this.http.post<Propriedade>(this.API + "/create", propriedade);
  }
  put(propriedade: Propriedade, id: Number): Observable<Propriedade> {
    return this.http.put<Propriedade>(this.API + "/update?id=" + id, propriedade);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  }
}
