import { ComponentFixture, TestBed, fakeAsync, tick, waitForAsync } from '@angular/core/testing';
import { AtributoDateilsComponent } from './atributo-dateils.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { By } from '@angular/platform-browser';
import { AtributoService } from 'src/app/SERVICE/atributo-service/atributo.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { of, throwError } from 'rxjs';


describe('Componente AtributoDateils', () => {
  let component: AtributoDateilsComponent;
  let fixture: ComponentFixture<AtributoDateilsComponent>;
  let atributoServiceSpy: jasmine.SpyObj<AtributoService>;
  let modalService: NgbModal;

  beforeEach(waitForAsync(() => {
    atributoServiceSpy = jasmine.createSpyObj('AtributoService', ['create', 'update']);

    TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientTestingModule],
      declarations: [AtributoDateilsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      providers: [
        { provide: NgbModal, useValue: jasmine.createSpyObj('NgbModal', ['dismissAll']) },
        { provide: AtributoService, useValue: atributoServiceSpy }
      ]
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


});
