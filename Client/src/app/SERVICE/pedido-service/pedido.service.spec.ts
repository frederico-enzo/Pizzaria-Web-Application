import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PedidoService } from './pedido.service';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

describe('PedidoService', () => {
  let service: PedidoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PedidoService]
    });

    service = TestBed.inject(PedidoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os pedidos via GET', () => {
    const mockPedidos: Pedido[] = [
      // Mockar alguns pedidos se necessário
    ];

    service.listAll().subscribe(pedidos => {
      expect(pedidos).toEqual(mockPedidos);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockPedidos);
  });

  it('deve encontrar um pedido por ID via GET', () => {
    const pedidoId = 1;
    const mockPedido: Pedido = {
      id: 0,
      cliente: new Cliente,
      valorTotal: 0,
      items: [],
      ativo: false
    };

    service.find(pedidoId).subscribe(pedido => {
      expect(pedido).toEqual(mockPedido);
    });

    const req = httpMock.expectOne(`${service.API}/${pedidoId}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockPedido);
  });

  it('deve criar um pedido via POST', () => {
    const mockPedido: Pedido = {
      id: 0,
      cliente: new Cliente,
      valorTotal: 0,
      items: [],
      ativo: false
    };
    service.create(mockPedido).subscribe(pedido => {
      expect(pedido).toEqual(mockPedido);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockPedido);
  });

  it('deve atualizar um pedido via PUT', () => {
    const pedidoId = 1;
    const mockPedido: Pedido = {
      id: 0,
      cliente: new Cliente,
      valorTotal: 0,
      items: [],
      ativo: false
    };

    service.update(mockPedido, pedidoId).subscribe(pedido => {
      expect(pedido).toEqual(mockPedido);
    });

    const req = httpMock.expectOne(`${service.API}/${pedidoId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockPedido);
  });

  it('deve deletar um pedido via DELETE', () => {
    const pedidoId = 1;

    service.delete(pedidoId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${pedidoId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
