import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from 'src/app/MODEL/item-model/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  API: string = 'http://localhost:8080/itens';
  http = inject(HttpClient);

  constructor() { }

  listAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.API);
  }

  create(item: Item): Observable<Item> {
    return this.http.post<Item>(this.API, item);
  }
  update(item:Item, id: Number):Observable<Item>{
    return this.http.put<Item>(this.API+"/"+id, item);
  } 
  delete(id: Number): Observable<void>{
    return this.http.delete<void>(this.API+"/"+id);
  } 
}
