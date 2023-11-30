import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, catchError, of, throwError } from 'rxjs';
import { Pizza } from 'src/app/MODEL/pizza-model/pizza';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {
  API: string = 'http://localhost:5000/pizzas';
  http = inject(HttpClient);

  constructor() { }


  listAll(): Observable<Pizza[]> {
    return this.http.get<Pizza[]>(this.API);
  }

  save(pizza: Pizza): Observable<Pizza> {
    return this.http.post<Pizza>(this.API, pizza).pipe(
      catchError((error) => {
        if (error.status === 201) {
          return of(error.response); 
        } else {
          return throwError(error);
        }
      })
    );
  }  

  exemploErro(): Observable<Pizza[]> {
    return this.http.get<Pizza[]>(this.API + '/erro');
  }

  update(pizza: Pizza): Observable<Pizza> {
    return this.http.put<Pizza>(`${this.API}/${pizza.id}`, pizza);
}
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.API}/${id}`);
  }


}