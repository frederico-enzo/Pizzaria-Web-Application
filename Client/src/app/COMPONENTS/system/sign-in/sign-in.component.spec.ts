import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { SignInComponent } from './sign-in.component';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/SERVICE/login-service/login.service';
import { of } from 'rxjs';
import { By } from '@angular/platform-browser';
import { Login } from 'src/app/MODEL/login-model/login';
import { throwError } from 'rxjs';

describe('SignInComponent', () => {
  let component: SignInComponent;
  let fixture: ComponentFixture<SignInComponent>;
  let mockRouter: jasmine.SpyObj<Router>;
  let mockLoginService: jasmine.SpyObj<LoginService>;

  beforeEach(waitForAsync(() => {
    mockRouter = jasmine.createSpyObj('Router', ['navigate']);
    mockLoginService = jasmine.createSpyObj('LoginService', ['logar', 'removeToken']);

    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [SignInComponent],
      providers: [
        { provide: Router, useValue: mockRouter },
        { provide: LoginService, useValue: mockLoginService }
      ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignInComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  beforeEach(()=>{
    let login = new Login();
    login.password = '1234';
    login.username = 'admin';
    component.login = login;
    fixture.detectChanges();
  })



  it('deve ser criado', () => {
    expect(component).toBeTruthy();
  });


  
  it('Teste @Input - Interpolação1 ', () => {
    let elemento = fixture.debugElement.query(By.css('input[name="exampleInputText1"]'));
    expect(elemento.nativeElement.ngModel).toEqual('admin');
  });

  it('Teste @Input - Interpolação1 null', () => {
    let elemento = fixture.debugElement.query(By.css('input[name="exampleInputText1"]'));
    expect(elemento.nativeElement.ngModel).not.toBe(null);
  });

  it('Teste @Input - Interpolação2 ', () => {
    let elemento = fixture.debugElement.query(By.css('input[name="exampleInputPassword1"]'));
    expect(elemento.nativeElement.ngModel).toEqual('1234');
  });

  it('Teste @Input - Interpolação2 null', () => {
    let elemento = fixture.debugElement.query(By.css('input[name="exampleInputPassword1"]'));
    expect(elemento.nativeElement.ngModel).not.toBe(null);
  });



  


});
