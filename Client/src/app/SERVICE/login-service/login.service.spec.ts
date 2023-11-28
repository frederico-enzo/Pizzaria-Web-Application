import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { LoginService } from './login.service';
import { Login } from 'src/app/MODEL/login-model/login';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

describe('LoginService', () => {
  let service: LoginService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [LoginService]
    });

    service = TestBed.inject(LoginService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve ser criado', () => {
    expect(service).toBeTruthy();
  });

  it('deve logar um usuário', () => {
    const login: Login = { username: 'testuser', password: 'testpassword' };
    const cliente = new Cliente();

    
    service.logar(login).subscribe(cliente => {
      return expect(cliente).toEqual(cliente);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(cliente);
  });

 
  it('deve adicionar um token ao localStorage', () => {
    const token = 'testtoken';

    service.addToken(token);

    const storedToken = localStorage.getItem('token');
    expect(storedToken).toEqual(token);
  });

  it('deve remover um token do localStorage', () => {
    localStorage.setItem('token', 'testtoken');

    service.removeToken();

    const storedToken = localStorage.getItem('token');
    expect(storedToken).toBeNull();
  });

  it('deve obter um token do localStorage', () => {
    const token = 'testtoken';
    localStorage.setItem('token', token);

    const storedToken = service.getToken();

    expect(storedToken).toEqual(token);
  });

  it('deve verificar permissão de ADMIN', () => {
    const role = 'ADMIN';

    const hasPermission = service.hasPermission(role);

    expect(hasPermission).toBeTruthy();
  });

  it('não deve verificar permissão para uma role não ADMIN', () => {
    const role = 'USER';

    const hasPermission = service.hasPermission(role);

    expect(hasPermission).toBeFalsy();
  });
});
