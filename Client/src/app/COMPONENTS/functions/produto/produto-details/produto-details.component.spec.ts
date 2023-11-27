import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ProdutoDetailsComponent } from './produto-details.component';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { By } from '@angular/platform-browser';

describe('ProdutoDetailsComponent', () => {
  let component: ProdutoDetailsComponent;
  let fixture: ComponentFixture<ProdutoDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ProdutoDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(ProdutoDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  beforeEach(() => {
    let produto = new Produto();
    produto.id = 1;
    produto.nome = 'pizza';
    produto.disponivel = true;
    produto.categoria = "massa";
    produto.tempoPreparo = 30;

    component.produto = produto;
    fixture.detectChanges();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });


  it('should not display "New" button when produto.id is greater than 0', () => {
    const produto = new Produto();
    produto.id = 1;
    component.produto = produto;
    fixture.detectChanges();
    const newButton = fixture.debugElement.query(By.css('button[w-30][btn-success]'));
    expect(newButton).toBeFalsy();
  });

});
