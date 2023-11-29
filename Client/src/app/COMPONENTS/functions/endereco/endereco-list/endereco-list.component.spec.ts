import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnderecoListComponent } from './endereco-list.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing'; 
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EnderecoService } from 'src/app/SERVICE/endereco-service/endereco.service';
import { of } from 'rxjs';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';

describe('EnderecoListComponent', () => {
  let component: EnderecoListComponent;
  let fixture: ComponentFixture<EnderecoListComponent>;
  let modalService: NgbModal;
  let service: EnderecoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [EnderecoListComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: { open: () => ({}) } },
        { provide: EnderecoService, useValue: { listAll: () => of([]) } },
      ],
    });
    fixture = TestBed.createComponent(EnderecoListComponent);
    component = fixture.componentInstance;
    modalService = TestBed.inject(NgbModal);
    service = TestBed.inject(EnderecoService);
    fixture.detectChanges();
  });

  it('deve ser criado', () => {
    expect(component).toBeTruthy();
  });

  it('deve chamar listAll() na construção', () => {
    spyOn(service, 'listAll').and.returnValue(of([]));

    fixture = TestBed.createComponent(EnderecoListComponent);
    component = fixture.componentInstance;

    expect(service.listAll).toHaveBeenCalled();
  });

  it('deve chamar adicionar() com sucesso', () => {
    spyOn(modalService, 'open').and.callThrough();

    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toEqual(new Endereco());
    expect(modalService.open).toHaveBeenCalledWith('modal', { size: 'xd' });
  });

  it('deve ter propriedades iniciais', () => {
    expect(component.lista).toEqual([]);
    expect(component.SelecionadaParaEdicao).toBeDefined();
    expect(component.indiceSelecionadoParaEdicao).toBeUndefined();
  });

  

  
});
