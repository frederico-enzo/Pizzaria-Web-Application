import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnderecoDetailsComponent } from './endereco-details.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';
import { of } from 'rxjs';
import { EnderecoService } from 'src/app/SERVICE/endereco-service/endereco.service';
import { By } from '@angular/platform-browser';

describe('EnderecoDetailsComponent', () => {
  let component: EnderecoDetailsComponent;
  let fixture: ComponentFixture<EnderecoDetailsComponent>;
  let enderecoService: EnderecoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [EnderecoDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: EnderecoService, useValue: { update: () => of(new Endereco()), save: () => of(new Endereco()) } },
      ],
    });
    fixture = TestBed.createComponent(EnderecoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  beforeEach(() => { 
    let endereco = new Endereco();
    component.endereco = endereco;
    fixture.detectChanges();
  });
  beforeEach(() => {
    fixture = TestBed.createComponent(EnderecoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should have @Output() retorno property', () => {
    expect(component.retorno).toBeTruthy();
  });
  it('should have @Input() cliente property', () => {
    const endereco = new Endereco();
    component.endereco = endereco;
    expect(component.endereco).toBe(endereco);
  });

  it('should have ClienteService property clienteService', () => {
    expect(component.endereco).toBeDefined();
  });
  it('should have @Input() cliente property', () => {
    const entity = new Endereco();
    component.endereco = entity;
    expect(component.endereco).toBe(entity);
  });



  it('should not display error message when error is false', () => {
    component.error = false;
    fixture.detectChanges();

    const alertElement = fixture.debugElement.query(By.css('.alert.alert-danger'));
    expect(alertElement).toBeFalsy();
  });

  it('should display error message when error is true', () => {
    component.error = true;
    component.mensagem = 'This is an error message';
    fixture.detectChanges();

    const alertElement = fixture.debugElement.query(By.css('.alert.alert-danger'));
    expect(alertElement).toBeTruthy();
    expect(alertElement.nativeElement.textContent.trim()).toBe('This is an error message');
  });
 
});

