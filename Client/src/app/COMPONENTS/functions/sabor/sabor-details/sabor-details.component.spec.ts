import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { SaborDetailsComponent } from './sabor-details.component';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';
import { By } from '@angular/platform-browser';

describe('SaborDetailsComponent', () => {
  let component: SaborDetailsComponent;
  let fixture: ComponentFixture<SaborDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [SaborDetailsComponent],
      schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
    });
    fixture = TestBed.createComponent(SaborDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  
  beforeEach(() => {
    let sabor = new Sabor();
    sabor.id=1;
    sabor.nome='calabresa';
    sabor.componentes= ['quijo','massa de tomate', 'calabresa', 'oregano']

    component.sabor = sabor;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have a default Sabor instance', () => {
    expect(component.sabor).toBeDefined();
    expect(component.sabor instanceof Sabor).toBeTruthy();
  });
  it('should have @Output() retorno property', () => {
    expect(component.retorno).toBeTruthy();
  });
    
  it('should have ClienteService property clienteService', () => {
    expect(component.sabor).toBeDefined();
  });

  it('should have @Input() cliente property', () => {
    const entity = new Sabor();
    component.sabor = entity;
    expect(component.sabor).toBe(entity);
  });
  it('should show error message when error is true', () => {
    component.error = true;
    component.mensagem = 'Erro de teste';
    fixture.detectChanges();
    const errorMessage = fixture.nativeElement.querySelector('.alert-danger');
    expect(errorMessage.textContent).toContain('Erro de teste');
  });



});
