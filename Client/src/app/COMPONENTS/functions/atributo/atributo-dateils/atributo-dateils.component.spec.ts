import { ComponentFixture, TestBed, fakeAsync, tick, waitForAsync } from '@angular/core/testing';
import { AtributoDateilsComponent } from './atributo-dateils.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { By } from '@angular/platform-browser';

describe('AtributoDateilsComponent', () => {
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


  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should initialize with an Atributo object', () => {
    expect(component.atributo).toBeDefined();
    expect(component.atributo instanceof Atributo).toBeTruthy();
  });


 it('should display descricao and preco inputs when atributo.id is greater than 0', () => {
    component.atributo.id = 1;
    fixture.detectChanges();

    const descricaoInput = fixture.debugElement.query(By.css('input[name="descricao"]'));
    const precoInput = fixture.debugElement.query(By.css('input[name="preco"]'));

    expect(descricaoInput).toBeTruthy();
    expect(precoInput).toBeTruthy();
  });




});
