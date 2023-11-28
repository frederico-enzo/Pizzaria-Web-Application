import { ComponentFixture, TestBed, fakeAsync, tick, waitForAsync } from '@angular/core/testing';
import { AtributoDateilsComponent } from './atributo-dateils.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { By } from '@angular/platform-browser';

describe('Componente AtributoDateils', () => {
  let component: AtributoDateilsComponent;
  let fixture: ComponentFixture<AtributoDateilsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule],
      declarations: [AtributoDateilsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AtributoDateilsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('deve ser criado', () => {
    expect(component).toBeTruthy();
  });

  it('deve ser inicializado com um objeto Atributo', () => {
    expect(component.atributo).toBeDefined();
    expect(component.atributo instanceof Atributo).toBeTruthy();
  });

  it('deve ter a propriedade @Input() atributo', () => {
    const entity = new Atributo();
    component.atributo = entity;
    expect(component.atributo).toBe(entity);
  });

  it('deve ter a propriedade @Output() retorno', () => {
    expect(component.retorno).toBeTruthy();
  });

  it('deve exibir os inputs descricao e preco quando atributo.id for maior que 0', () => {
    component.atributo.id = 1;
    fixture.detectChanges();

    const descricaoInput = fixture.debugElement.query(By.css('input[name="descricao"]'));
    const precoInput = fixture.debugElement.query(By.css('input[name="preco"]'));

    expect(descricaoInput).toBeTruthy();
    expect(precoInput).toBeTruthy();
  });

  it('não deve exibir os inputs descricao e preco quando atributo.id for nulo', () => {
    component.atributo.id = 0;
    fixture.detectChanges();

    const descricaoInput = fixture.debugElement.query(By.css('input[name="descricao"]'));
    const precoInput = fixture.debugElement.query(By.css('input[name="preco"]'));

    expect(descricaoInput).toBeFalsy();
    expect(precoInput).toBeFalsy();
  });
});
