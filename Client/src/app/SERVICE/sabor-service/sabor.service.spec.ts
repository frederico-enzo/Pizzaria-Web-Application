import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { SaborService } from './sabor.service';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';

describe('SaborService', () => {
  let service: SaborService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [SaborService]
    });

    service = TestBed.inject(SaborService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os sabores via GET', () => {
    const mockSabores: Sabor[] = [
      // Mockar alguns sabores se necessário
    ];

    service.listAll().subscribe(sabores => {
      expect(sabores).toEqual(mockSabores);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockSabores);
  });

  it('deve criar um sabor via POST', () => {
    const mockSabor: Sabor = {
      id: 0,
      nome: '',
      componentes: []
    };


    service.create(mockSabor).subscribe(sabor => {
      expect(sabor).toEqual(mockSabor);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockSabor);
  });

  it('deve atualizar um sabor via PUT', () => {
    const saborId = 1;
    const mockSabor: Sabor = {
      id: 0,
      nome: '',
      componentes: []
    };

    service.update(mockSabor, saborId).subscribe(sabor => {
      expect(sabor).toEqual(mockSabor);
    });

    const req = httpMock.expectOne(`${service.API}/${saborId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockSabor);
  });

  it('deve deletar um sabor via DELETE', () => {
    const saborId = 1;

    service.delete(saborId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${saborId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
