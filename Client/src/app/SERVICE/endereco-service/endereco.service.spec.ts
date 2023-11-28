import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { EnderecoService } from './endereco.service';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

describe('EnderecoService', () => {
  let service: EnderecoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [EnderecoService]
    });

    service = TestBed.inject(EnderecoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os endereços via GET', () => {
    const mockEnderecos: Endereco[] = [
      // Mockar alguns endereços se necessário
    ];

    service.listAll().subscribe(enderecos => {
      expect(enderecos).toEqual(mockEnderecos);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockEnderecos);
  });

  it('deve criar um endereço via POST', () => {
    const mockEndereco: Endereco = {
      id: 0,
      rua: "",
      bairro: "",
      numero: "",
      cep: 0
    };


    service.create(mockEndereco).subscribe(endereco => {
      expect(endereco).toEqual(mockEndereco);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockEndereco);
  });

  it('deve atualizar um endereço via PUT', () => {
    const enderecoId = 1;
    const mockEndereco: Endereco = {
      id: 0,
      rua: "",
      bairro: "",
      numero: "",
      cep: 0
    };

    service.update(mockEndereco, enderecoId).subscribe(endereco => {
      expect(endereco).toEqual(mockEndereco);
    });

    const req = httpMock.expectOne(`${service.API}/${enderecoId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockEndereco);
  });

  it('deve deletar um endereço via DELETE', () => {
    const enderecoId = 1;

    service.delete(enderecoId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${enderecoId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
