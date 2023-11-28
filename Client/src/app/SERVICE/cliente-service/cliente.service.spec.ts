import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ClienteService } from './cliente.service';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

describe('ClienteService', () => {
  let service: ClienteService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClienteService]
    });

    service = TestBed.inject(ClienteService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os clientes via GET', () => {
    const mockClientes: Cliente[] = [
    ];

    service.listAll().subscribe(clientes => {
      expect(clientes).toEqual(mockClientes);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockClientes);
  });

  it('deve encontrar um cliente por ID via GET', () => {
    const clientId = 1;
    const mockCliente: Cliente = {
      id: 0,
      username: '',
      password: '',
      token: '',
      endereco: new Endereco
    };

    service.findById(clientId).subscribe(cliente => {
      expect(cliente).toEqual(mockCliente);
    });

    const req = httpMock.expectOne(`${service.API}/${clientId}`);
    expect(req.request.method).toBe('GET');
    req.flush(mockCliente);
  });

  it('deve criar um cliente via POST', () => {
    const mockCliente: Cliente = {
      id: 0,
      username: '',
      password: '',
      token: '',
      endereco: new Endereco
    };

    service.create(mockCliente).subscribe(cliente => {
      expect(cliente).toEqual(mockCliente);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockCliente);
  });

  it('deve atualizar um cliente via PUT', () => {
    const clientId = 1;
    const mockCliente: Cliente = {
      id: 0,
      username: '',
      password: '',
      token: '',
      endereco: new Endereco
    };

    service.update(mockCliente, clientId).subscribe(cliente => {
      expect(cliente).toEqual(mockCliente);
    });

    const req = httpMock.expectOne(`${service.API}/${clientId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockCliente);
  });

  it('deve deletar um cliente via DELETE', () => {
    const clientId = 1;

    service.delete(clientId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${clientId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
