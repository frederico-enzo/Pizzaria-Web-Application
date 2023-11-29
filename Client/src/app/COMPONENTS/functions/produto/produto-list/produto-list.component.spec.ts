import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, inject } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ProdutoListComponent } from './produto-list.component';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { Produto } from 'src/app/MODEL/produto-model/produto';

describe('ProdutoListComponent', () => {
  let component: ProdutoListComponent;
  let fixture: ComponentFixture<ProdutoListComponent>;
  let modalService: NgbModal;
  let service: ProdutoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdutoListComponent],
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: { open: () => ({}) } },
        { provide: ProdutoService, useValue: { listAll: () => of([]) } },
      ],
    });
    fixture = TestBed.createComponent(ProdutoListComponent);
    component = fixture.componentInstance;
    modalService = TestBed.inject(NgbModal);
    service = TestBed.inject(ProdutoService);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should call listAll() on construction', () => {
    spyOn(service, 'listAll').and.returnValue(of([]));

    fixture = TestBed.createComponent(ProdutoListComponent);
    component = fixture.componentInstance;

    expect(service.listAll).toHaveBeenCalled();
  });

  
  it('should call adicionar() method successfully', () => {
    spyOn(modalService, 'open').and.callThrough();

    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toEqual(new Produto());
    expect(modalService.open).toHaveBeenCalledWith('modal', { size: 'xd' });
  });


  it('should have initial properties', () => {
    expect(component.lista).toEqual([]);
    expect(component.SelecionadaParaEdicao).toBeDefined();
    expect(component.indiceSelecionadoParaEdicao).toBeUndefined();
  });
  it('should set the SelecionadaParaEdicao property to a new Atributo object when the adicionar function is called', () => {
    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toBeInstanceOf(Produto);
    expect(component.SelecionadaParaEdicao).toEqual(new Produto());
  });

  it('should set the indiceSelecionadoParaEdicao property to the edited atributo index when the editar function is called', () => {
    const entity = new Produto();
    const indice = 0;

    component.editar('modal', entity, indice);

    expect(component.indiceSelecionadoParaEdicao).toEqual(indice);
  });

});
