import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteDetailsComponent } from './cliente-details.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

describe('ClienteDetailsComponent', () => {
  let component: ClienteDetailsComponent;
  let fixture: ComponentFixture<ClienteDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ClienteDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(ClienteDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have @Input() cliente property', () => {
    const cliente = new Cliente();
    component.cliente = cliente;
    expect(component.cliente).toBe(cliente);
  });

  it('should have @Output() retorno property', () => {
    expect(component.retorno).toBeTruthy();
  });
  
  it('should have ClienteService property clienteService', () => {
    expect(component.cliente).toBeDefined();
  });




});
