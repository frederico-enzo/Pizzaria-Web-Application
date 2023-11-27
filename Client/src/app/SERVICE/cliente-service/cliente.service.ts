import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  API: string = 'http://localhost:8080/clientes';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.API);
  }
  
  findById(id: Number): Observable<Cliente> {
    return this.http.get<Cliente>(this.API+"/"+id);
  }

  create(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.API, cliente);
  }

  update(cliente:Cliente, id: Number):Observable<Cliente>{
    return this.http.put<Cliente>(this.API+"/"+id, cliente);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
