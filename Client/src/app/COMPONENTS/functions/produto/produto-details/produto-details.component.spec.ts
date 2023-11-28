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


  it('test @Input 1 ', () => {
    let element = fixture.debugElement.query(By.css('input[name="nome"]'))
    expect(element.nativeElement.ngModel).toEqual('pizza');
  });

  it('test @Input 2 ', () => {
    let element = fixture.debugElement.query(By.css('input[name="categoria"]'))
    expect(element.nativeElement.ngModel).toEqual('massa');
  });

  it('test @Input 3 ', () => {
    let element = fixture.debugElement.query(By.css('input[name="tempoPreparo"]'))
    expect(element.nativeElement.ngModel).toEqual(30);
  });

  it('test @Input 1 to be null', () => {
    let element = fixture.debugElement.query(By.css('input[name="nome"]'))
    expect(element.nativeElement.ngModel).not.toBe(null);
  });

  it('test @Input 2 to be null', () => {
    let element = fixture.debugElement.query(By.css('input[name="categoria"]'))
    expect(element.nativeElement.ngModel).not.toBe(null);
  });

  it('test @Input 3 to be null', () => {
    let element = fixture.debugElement.query(By.css('input[name="tempoPreparo"]'))
    expect(element.nativeElement.ngModel).not.toBe(null);
  });
  
});
