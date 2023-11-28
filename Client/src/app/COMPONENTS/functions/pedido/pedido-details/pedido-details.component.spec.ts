import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PedidoDetailsComponent } from './pedido-details.component';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';

describe('PedidoDetailsComponent', () => {
  let component: PedidoDetailsComponent;
  let fixture: ComponentFixture<PedidoDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [PedidoDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(PedidoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should have @Output() retorno property', () => {
    expect(component.retorno).toBeTruthy();
  });
  it('should have ClienteService property clienteService', () => {
    expect(component.pedido).toBeDefined();
  });
  it('should have @Output() retorno property', () => {
    expect(component.retorno).toBeTruthy();
  });
  it('should have @Input() cliente property', () => {
    const entity = new Pedido();
    component.pedido = entity;
    expect(component.pedido).toBe(entity);
  });

});
