import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoListComponent } from './atributo-list.component';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';

describe('AtributoListComponent', () => {
  let component: AtributoListComponent;
  let fixture: ComponentFixture<AtributoListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
      declarations: [AtributoListComponent]
    });
    fixture = TestBed.createComponent(AtributoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
