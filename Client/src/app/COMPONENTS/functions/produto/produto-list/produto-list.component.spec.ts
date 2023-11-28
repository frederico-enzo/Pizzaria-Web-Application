import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA, inject } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ProdutoListComponent } from './produto-list.component';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';

describe('ProdutoListComponent', () => {
  let component: ProdutoListComponent;
  let fixture: ComponentFixture<ProdutoListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProdutoListComponent],
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: ProdutoService, useValue: { listAll: () => of([]), exemploErro: () => of([]), delete: () => of({}) } },
        { provide: NgbModal, useValue: { open: () => ({}) } },
      ],
    });

    fixture = TestBed.createComponent(ProdutoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


});
