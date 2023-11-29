import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AdmHeaderComponent } from './adm-header.component';

describe('AdmHeaderComponent', () => {
  let component: AdmHeaderComponent;
  let fixture: ComponentFixture<AdmHeaderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [AdmHeaderComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(AdmHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdmHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should contain navigation links', () => {
    const compiled = fixture.nativeElement;

    const links = compiled.querySelectorAll('ul.navbar-nav li');
    expect(links.length).toBe(7); // O número de links esperados

    const atributoLink = compiled.querySelector('li.nav-item.btn-warning p[routerLink="/admin/atributo-adm"]');
    expect(atributoLink).toBeTruthy();

    const clienteLink = compiled.querySelector('li.nav-item.btn-warning p[routerLink="/admin/cliente-adm"]');
    expect(clienteLink).toBeTruthy();


    const sairLink = compiled.querySelector('li.nav-item.btn-danger p[routerLink="/login"]');
    expect(sairLink).toBeTruthy();
  });
});
