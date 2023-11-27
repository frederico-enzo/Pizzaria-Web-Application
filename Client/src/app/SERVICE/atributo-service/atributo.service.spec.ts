import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { AtributoService } from './atributo.service';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';

describe('AtributoService', () => {
  let service: AtributoService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AtributoService],
    });

    service = TestBed.inject(AtributoService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify(); 
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a list of Atributo on listAll()', () => {
    const dummyAtributos: Atributo[] = [
      { id: 1, tamanho: 'Small', descricao: 'Descrição 1', preco: 10.0 },
      { id: 2, tamanho: 'Medium', descricao: 'Descrição 2', preco: 15.0 },
    ];

    service.listAll().subscribe((atributos) => {
      expect(atributos).toEqual(dummyAtributos);
    });

    const req = httpTestingController.expectOne(service.API);
    expect(req.request.method).toEqual('GET');

    req.flush(dummyAtributos);
  });

  it('should create a new Atributo on create()', () => {
    const newAtributo: Atributo = { id: 3, tamanho: 'Large', descricao: 'Nova Descrição', preco: 20.0 };

    service.create(newAtributo).subscribe((createdAtributo) => {
      expect(createdAtributo).toEqual(newAtributo);
    });

    const req = httpTestingController.expectOne(service.API);
    expect(req.request.method).toEqual('POST');

    req.flush(newAtributo);
  });

});
