import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { ClienteListComponent } from './cliente-list.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { of, throwError } from 'rxjs';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

describe('ClienteListComponent', () => {
  let component: ClienteListComponent;
  let fixture: ComponentFixture<ClienteListComponent>;
  let modalService: NgbModal;
  let clienteService: ClienteService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClienteListComponent],
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: { open: () => ({}) } },
        { provide: ClienteService, useValue: { listAll: () => of([]) } },
      ],
    });

    fixture = TestBed.createComponent(ClienteListComponent);
    component = fixture.componentInstance;
    modalService = TestBed.inject(NgbModal);
    clienteService = TestBed.inject(ClienteService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
  it('should call adicionar() method successfully', () => {
    spyOn(modalService, 'open').and.callThrough();

    component.adicionar('modal');

    expect(component.SelecionadoParaEdicao).toEqual(new Cliente());
    expect(modalService.open).toHaveBeenCalledWith('modal', { size: 'lg' });
  });

  it('should set the SelecionadaParaEdicao property to a new Atributo object when the adicionar function is called', () => {
    component.adicionar('modal');

    expect(component.SelecionadoParaEdicao).toBeInstanceOf(Cliente);
    expect(component.SelecionadoParaEdicao).toEqual(new Cliente());
  });


  
  it('should set the indiceSelecionadoParaEdicao property to the edited atributo index when the editar function is called', () => {
    const entity = new Cliente();
    const indice = 0;

    component.editar('modal', entity, indice);

    expect(component.indiceSelecionadoParaEdicao).toEqual(indice);
  });



});
