import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { SaborListComponent } from './sabor-list.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { SaborService } from 'src/app/SERVICE/sabor-service/sabor.service';
import { of } from 'rxjs';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';

describe('SaborListComponent', () => {
  let component: SaborListComponent;
  let fixture: ComponentFixture<SaborListComponent>;
  let modalService: NgbModal;
  let service: SaborService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [SaborListComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: { open: () => ({}) } },
        { provide: SaborService, useValue: { listAll: () => of([]) } },
      ],
    });
    fixture = TestBed.createComponent(SaborListComponent);
    component = fixture.componentInstance;
    modalService = TestBed.inject(NgbModal);
    service = TestBed.inject(SaborService);
    fixture.detectChanges();
  });
  
  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
  it('should call listAll() on construction', () => {
    spyOn(service, 'listAll').and.returnValue(of([]));

    fixture = TestBed.createComponent(SaborListComponent);
    component = fixture.componentInstance;

    expect(service.listAll).toHaveBeenCalled();
  });

  
  it('should call adicionar() method successfully', () => {
    spyOn(modalService, 'open').and.callThrough();

    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toEqual(new Sabor());
    expect(modalService.open).toHaveBeenCalledWith('modal', { size: 'xd' });
  });

  it('should have initial properties', () => {
    expect(component.lista).toEqual([]);
    expect(component.SelecionadaParaEdicao).toBeDefined();
    expect(component.indiceSelecionadoParaEdicao).toBeUndefined();
  });

  it('should set the SelecionadaParaEdicao property to a new Atributo object when the adicionar function is called', () => {
    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toBeInstanceOf(Sabor);
    expect(component.SelecionadaParaEdicao).toEqual(new Sabor());
  });

  
  it('should set the indiceSelecionadoParaEdicao property to the edited atributo index when the editar function is called', () => {
    const entity = new Sabor();
    const indice = 0;

    component.editar('modal', entity, indice);

    expect(component.indiceSelecionadoParaEdicao).toEqual(indice);
  });
});
