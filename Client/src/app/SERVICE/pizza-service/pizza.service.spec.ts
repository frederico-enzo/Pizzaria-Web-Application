import { HttpClient, HttpClientModule } from '@angular/common/http';
import { inject, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PizzaService } from './pizza.service';
import { Pizza } from 'src/app/MODEL/pizza-model/pizza';
import { of, throwError } from 'rxjs';

describe('PizzaService', () => {
  let service: PizzaService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PizzaService]
    });
    service = TestBed.inject(PizzaService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should list all pizzas', () => {
    const mockPizzas: Pizza[] = [
      { id: 1, valor: 10, tamanho: 'Média', sabores: [] },
      { id: 2, valor: 15, tamanho: 'Grande', sabores: [] }
    ];

    service.listAll().subscribe((pizzas) => {
      expect(pizzas).toEqual(mockPizzas);
    });

    const req = httpMock.expectOne(`${service.API}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockPizzas);
  });

  it('should save a pizza', () => {
    const mockPizza: Pizza = { id: 1, valor: 10, tamanho: 'Média', sabores: [] };

    service.save(mockPizza).subscribe((pizza) => {
      expect(pizza).toEqual(mockPizza);
    });

    const req = httpMock.expectOne(`${service.API}`);
    expect(req.request.method).toBe('POST');
    req.flush(mockPizza);
  });
 

  it('should update a pizza', () => {
    const mockPizza: Pizza = { id: 1, valor: 12, tamanho: 'Grande', sabores: [] };

    service.update(mockPizza).subscribe((pizza) => {
      expect(pizza).toEqual(mockPizza);
    });

    const req = httpMock.expectOne(`${service.API}/${mockPizza.id}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockPizza);
  });

  it('should delete a pizza', () => {
    const pizzaId = 1;

    service.delete(pizzaId).subscribe(() => {
      expect().nothing();
    });

    const req = httpMock.expectOne(`${service.API}/${pizzaId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });

  afterEach(() => {
    httpMock.verify();
  });
});
