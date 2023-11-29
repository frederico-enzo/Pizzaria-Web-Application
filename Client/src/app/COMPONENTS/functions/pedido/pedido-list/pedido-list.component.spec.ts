import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { PedidoListComponent } from './pedido-list.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PedidoService } from 'src/app/SERVICE/pedido-service/pedido.service';
import { of } from 'rxjs';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';

describe('PedidoListComponent', () => {
  let component: PedidoListComponent;
  let fixture: ComponentFixture<PedidoListComponent>;
  let modalService: NgbModal;
  let service: PedidoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [PedidoListComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: { open: () => ({}) } },
        { provide: PedidoService, useValue: { listAll: () => of([]) } },
      ],
    });
    fixture = TestBed.createComponent(PedidoListComponent);
    component = fixture.componentInstance;
    modalService = TestBed.inject(NgbModal);
    service = TestBed.inject(PedidoService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call listAll() on construction', () => {
    spyOn(service, 'listAll').and.returnValue(of([]));

    fixture = TestBed.createComponent(PedidoListComponent);
    component = fixture.componentInstance;

    expect(service.listAll).toHaveBeenCalled();
  });
  
  it('should call adicionar() method successfully', () => {
    spyOn(modalService, 'open').and.callThrough();

    component.adicionar('modal');

    expect(component.SelecionadoParaEdicao).toEqual(new Pedido());
    expect(modalService.open).toHaveBeenCalledWith('modal', { size: 'lg' });
  });

  it('should have initial properties', () => {
    expect(component.lista).toEqual([]);
    expect(component.SelecionadoParaEdicao).toBeDefined();
    expect(component.indiceSelecionadoParaEdicao).toBeUndefined();
  });

  it('should set the SelecionadaParaEdicao property to a new Atributo object when the adicionar function is called', () => {
    component.adicionar('modal');

    expect(component.SelecionadoParaEdicao).toBeInstanceOf(Pedido);
    expect(component.SelecionadoParaEdicao).toEqual(new Pedido());
  });

  it('should set the indiceSelecionadoParaEdicao property to the edited atributo index when the editar function is called', () => {
    const entity = new Pedido();
    const indice = 0;

    component.editar('modal', entity, indice);

    expect(component.indiceSelecionadoParaEdicao).toEqual(indice);
  });

});
