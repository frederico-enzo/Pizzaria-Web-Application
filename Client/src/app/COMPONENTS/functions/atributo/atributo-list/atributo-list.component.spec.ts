import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoListComponent } from './atributo-list.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';

describe('AtributoListComponent', () => {
  let component: AtributoListComponent;
  let fixture: ComponentFixture<AtributoListComponent>;
  let h3: HTMLElement;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      declarations: [AtributoListComponent]
    });
    fixture = TestBed.createComponent(AtributoListComponent);
    component = fixture.componentInstance;
    h3 = fixture.nativeElement.querySelector('h3');
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

 


  it('should set the indiceSelecionadoParaEdicao property to the edited atributo index when the editar function is called', () => {
    const entity = new Atributo();
    const indice = 0;

    component.editar('modal', entity, indice);

    expect(component.indiceSelecionadoParaEdicao).toEqual(indice);
  });

  it('should set the SelecionadaParaEdicao property to a new Atributo object when the adicionar function is called', () => {
    component.adicionar('modal');

    expect(component.SelecionadaParaEdicao).toBeInstanceOf(Atributo);
    expect(component.SelecionadaParaEdicao).toEqual(new Atributo());
  });



});