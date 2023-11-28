import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ItemService } from './item.service';
import { Item } from 'src/app/MODEL/item-model/item';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';

describe('ItemService', () => {
  let service: ItemService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ItemService]
    });

    service = TestBed.inject(ItemService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os itens via GET', () => {
    const mockItens: Item[] = [
      // Mockar alguns itens se necessário
    ];

    service.listAll().subscribe(itens => {
      expect(itens).toEqual(mockItens);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockItens);
  });

  it('deve criar um item via POST', () => {
    const mockItem: Item = {
      id: 0,
      produto: new Produto,
      quantidade: 0,
      sabors: [],
      atributoEspecifico: new Atributo,
      pedido: new Pedido
    };

    service.create(mockItem).subscribe(item => {
      expect(item).toEqual(mockItem);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockItem);
  });

  it('deve atualizar um item via PUT', () => {
    const itemId = 1;
    const mockItem: Item = {
      id: 0,
      produto: new Produto,
      quantidade: 0,
      sabors: [],
      atributoEspecifico: new Atributo,
      pedido: new Pedido
    };

    service.update(mockItem, itemId).subscribe(item => {
      expect(item).toEqual(mockItem);
    });

    const req = httpMock.expectOne(`${service.API}/${itemId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockItem);
  });

  it('deve deletar um item via DELETE', () => {
    const itemId = 1;

    service.delete(itemId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${itemId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
