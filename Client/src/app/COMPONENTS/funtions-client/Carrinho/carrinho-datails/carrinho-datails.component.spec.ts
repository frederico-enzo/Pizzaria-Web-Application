import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrinhoDatailsComponent } from './carrinho-datails.component';

describe('CarrinhoDatailsComponent', () => {
  let component: CarrinhoDatailsComponent;
  let fixture: ComponentFixture<CarrinhoDatailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CarrinhoDatailsComponent]
    });
    fixture = TestBed.createComponent(CarrinhoDatailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
