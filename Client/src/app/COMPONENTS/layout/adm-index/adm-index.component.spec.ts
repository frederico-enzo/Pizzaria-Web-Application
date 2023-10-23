import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdmIndexComponent } from './adm-index.component';

describe('AdmIndexComponent', () => {
  let component: AdmIndexComponent;
  let fixture: ComponentFixture<AdmIndexComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdmIndexComponent]
    });
    fixture = TestBed.createComponent(AdmIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
