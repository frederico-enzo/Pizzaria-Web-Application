import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProdutoListInterfaceComponent } from './produto-list-interface.component';

describe('ProdutoListInterfaceComponent', () => {
  let component: ProdutoListInterfaceComponent;
  let fixture: ComponentFixture<ProdutoListInterfaceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdutoListInterfaceComponent]
    });
    fixture = TestBed.createComponent(ProdutoListInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
