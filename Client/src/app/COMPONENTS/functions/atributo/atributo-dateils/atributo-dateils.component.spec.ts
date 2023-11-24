import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtributoDateilsComponent } from './atributo-dateils.component';

describe('AtributoDateilsComponent', () => {
  let component: AtributoDateilsComponent;
  let fixture: ComponentFixture<AtributoDateilsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AtributoDateilsComponent]
    });
    fixture = TestBed.createComponent(AtributoDateilsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
