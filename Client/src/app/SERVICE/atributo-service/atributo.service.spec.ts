import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AtributoService } from './atributo.service';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';

describe('AtributoService', () => {
  let service: AtributoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AtributoService]
    });

    service = TestBed.inject(AtributoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os atributos via GET', () => {
    const mockAtributos: Atributo[] = [
      // Mockar alguns atributos se necessário
    ];

    service.listAll().subscribe(atributos => {
      expect(atributos).toEqual(mockAtributos);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockAtributos);
  });

  it('deve criar um atributo via POST', () => {
    const mockAtributo: Atributo = {
      id: 0,
      tamanho: '',
      descricao: '',
      preco: 0
    };

    service.create(mockAtributo).subscribe(atributo => {
      expect(atributo).toEqual(mockAtributo);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockAtributo);
  });

  it('deve atualizar um atributo via PUT', () => {
    const atributoId = 1;
    const mockAtributo: Atributo = {
      id: 0,
      tamanho: '',
      descricao: '',
      preco: 0
    };

    service.update(mockAtributo, atributoId).subscribe(atributo => {
      expect(atributo).toEqual(mockAtributo);
    });

    const req = httpMock.expectOne(`${service.API}/${atributoId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockAtributo);
  });

  it('deve deletar um atributo via DELETE', () => {
    const atributoId = 1;

    service.delete(atributoId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${atributoId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });

  
});
