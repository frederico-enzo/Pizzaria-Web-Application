import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  API: string = 'http://localhost:8080/pedidos';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(this.API);
  }

  create(pedido: Pedido): Observable<Pedido> {
    return this.http.post<Pedido>(this.API, pedido);
  }
  update(pedido:Pedido, id: Number):Observable<Pedido>{
    return this.http.put<Pedido>(this.API+"/"+id, pedido);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
