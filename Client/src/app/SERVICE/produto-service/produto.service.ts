import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from 'src/app/MODEL/produto-model/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  API: string = 'http://localhost:8080/produtos';
  http = inject(HttpClient);

  constructor() { }
  findById(id: Number): Observable<Produto> {
    return this.http.delete<Produto>(this.API + "/find?id=" + id);
  }
  listAll(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.API + "/findAll");
  }
  post(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.API + "/create", produto);
  }
  put(produto: Produto, id: Number): Observable<Produto> {
    return this.http.put<Produto>(this.API + "/update?id=" + id, produto);
  }
  delete(id: Number): Observable<void> {
    return this.http.delete<void>(this.API + "/delete?id=" + id);
  } 
}
