import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteDateilsInterfaceComponent } from './cliente-dateils-interface.component';

describe('ClienteDateilsInterfaceComponent', () => {
  let component: ClienteDateilsInterfaceComponent;
  let fixture: ComponentFixture<ClienteDateilsInterfaceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ClienteDateilsInterfaceComponent]
    });
    fixture = TestBed.createComponent(ClienteDateilsInterfaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
