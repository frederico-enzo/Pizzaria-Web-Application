import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FuncionarioService } from './funcionario.service';
import { Funcionario } from 'src/app/MODEL/funcionario-model/funcionario';
import { HttpErrorResponse } from '@angular/common/http';

describe('FuncionarioService', () => {
  let service: FuncionarioService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FuncionarioService]
    });

    service = TestBed.inject(FuncionarioService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should list all funcionarios', () => {
    const mockFuncionarios: Funcionario[] = [
      { id: 1, nome: 'Funcionario 1', idade: 25, cpf: '12345678901', email: 'funcionario1@example.com', senha: 'senha123', telefone: '123456789' },
      { id: 2, nome: 'Funcionario 2', idade: 30, cpf: '98765432101', email: 'funcionario2@example.com', senha: 'senha456', telefone: '987654321' }
    ];

    service.listAll().subscribe(funcionarios => {
      expect(funcionarios).toEqual(mockFuncionarios);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockFuncionarios);
  });

  it('should save a new funcionario', () => {
    const newFuncionario: Funcionario = new Funcionario();
    newFuncionario.id = 1;
    newFuncionario.nome = 'John Doe';
    newFuncionario.idade = 30;
    newFuncionario.cpf = '123.456.789-01';
    newFuncionario.email = 'john.doe@example.com';
    newFuncionario.senha = 'senha123';
    newFuncionario.telefone = '123456789';
    service.save(newFuncionario).subscribe(funcionario => {
      expect(funcionario).toEqual(newFuncionario);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(newFuncionario);
  });

  it('should handle save error with status other than 201', () => {
    const newFuncionario: Funcionario = new Funcionario();
    // Set the properties of newFuncionario
    const errorResponse = { status: 500, message: 'Internal Server Error' };

    service.save(newFuncionario).subscribe(
      () => fail('Expected an error, but received a response'),
      (error: any) => {
        expect(error instanceof HttpErrorResponse).toBeTruthy();
        expect(error.status).toBe(500);
        expect(error.error).toEqual(errorResponse);
      }
    );

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(errorResponse, { status: 500, statusText: 'Internal Server Error' });
  });

  it('should handle save error with status other than 201', () => {
    const newFuncionario: Funcionario = {
      id: 1,
      nome: 'John Doe',
      idade: 30,
      cpf: '123.456.789-01',
      email: 'john.doe@example.com',
      senha: 'senha123',
      telefone: '123456789',
    };
  
    service.save(newFuncionario).subscribe(
      () => fail('Expected an error, but received a response'),
      (error: any) => {
        expect(error instanceof HttpErrorResponse).toBeTruthy();
        expect(error.status).not.toBe(201);
      }
    );
  
    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush({}, { status: 500, statusText: 'Internal Server Error' });
  });
  
  
  it('should handle exemploErro', () => {
    const errorResponse = { status: 500, message: 'Internal Server Error' };

    service.exemploErro().subscribe(
      () => fail('Expected an error, but received a response'),
      (error: any) => {
        expect(error instanceof HttpErrorResponse).toBeTruthy();
        expect(error.status).toBe(500);
        expect(error.error).toEqual(errorResponse);
      }
    );

    const req = httpMock.expectOne(`${service.API}/erro`);
    expect(req.request.method).toBe('GET');
    req.flush(errorResponse, { status: 500, statusText: 'Internal Server Error' });
  });

  it('should update an existing funcionario', () => {
    const updatedFuncionario: Funcionario = { id: 1, nome: 'Funcionario Atualizado', idade: 26, cpf: '12345678901', email: 'funcionario1@example.com', senha: 'senha123', telefone: '123456789' };

    service.update(updatedFuncionario).subscribe(funcionario => {
      expect(funcionario).toEqual(updatedFuncionario);
    });

    const req = httpMock.expectOne(`${service.API}/${updatedFuncionario.id}`);
    expect(req.request.method).toBe('PUT');
    req.flush(updatedFuncionario);
  });

  it('should delete a funcionario', () => {
    const funcionarioId = 1;

    service.delete(funcionarioId).subscribe(() => {
      // No assertions here since a successful delete doesn't return a response body
    });

    const req = httpMock.expectOne(`${service.API}/${funcionarioId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush({});
  });
});
