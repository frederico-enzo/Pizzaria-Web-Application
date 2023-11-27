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


  it('Test  de 1 @Input - Interpolação no templete'),() => {
    let element = fixture.debugElement.query(By.css('input[name="nome"]'));
    expect(element.nativeElement.NgModel).toEqual('calabresa');

  }  

});
