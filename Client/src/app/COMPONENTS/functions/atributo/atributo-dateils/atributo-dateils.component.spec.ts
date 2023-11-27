import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoDateilsComponent } from './atributo-dateils.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { By } from '@angular/platform-browser';
import { NgModel } from '@angular/forms';

describe('AtributoDateilsComponent', () => {
  let component: AtributoDateilsComponent;
  let fixture: ComponentFixture<AtributoDateilsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [AtributoDateilsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(AtributoDateilsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  beforeEach(() => {
    let atributo = new Atributo();
    atributo.id = 1;
    atributo.descricao = "8 pedaços";
    atributo.preco = 152;
    atributo.tamanho = "GRANDE"

    component.atributo = atributo;
    fixture.detectChanges();
  })

  it('Test  de 1 @Input - Interpolação no templete'),() => {
    let element = fixture.debugElement.query(By.css('input[name="tamanho"]'));
    expect(element.nativeElement.NgModel).toEqual('GRANDE');

  }  



});
