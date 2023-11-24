import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoListComponent } from './atributo-list.component';

describe('AtributoListComponent', () => {
  let component: AtributoListComponent;
  let fixture: ComponentFixture<AtributoListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
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
