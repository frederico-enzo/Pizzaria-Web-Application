import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnderecoDetailsComponent } from './endereco-details.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

describe('EnderecoDetailsComponent', () => {
  let component: EnderecoDetailsComponent;
  let fixture: ComponentFixture<EnderecoDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [EnderecoDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
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


});
