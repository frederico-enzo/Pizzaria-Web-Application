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

  listAll(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.API);
  }

  create(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(this.API, produto);
  }
  update(produto:Produto, id: Number):Observable<Produto>{
    return this.http.put<Produto>(this.API+"/"+id, produto);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
