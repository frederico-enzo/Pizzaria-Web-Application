import { TestBed, inject } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ProdutoService } from './produto.service';
import { Produto } from 'src/app/MODEL/produto-model/produto';

describe('ProdutoService', () => {
  let service: ProdutoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProdutoService]
    });

    service = TestBed.inject(ProdutoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve listar todos os produtos via GET', () => {
    const mockProdutos: Produto[] = [
      // Mockar alguns produtos se necessário
    ];

    service.listAll().subscribe(produtos => {
      expect(produtos).toEqual(mockProdutos);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('GET');
    req.flush(mockProdutos);
  });

  it('deve criar um produto via POST', () => {
    const mockProduto: Produto = {
      id: 0,
      nome: '',
      categoria: '',
      disponivel: false,
      tempoPreparo: 0
    };

    service.create(mockProduto).subscribe(produto => {
      expect(produto).toEqual(mockProduto);
    });

    const req = httpMock.expectOne(service.API);
    expect(req.request.method).toBe('POST');
    req.flush(mockProduto);
  });

  it('deve atualizar um produto via PUT', () => {
    const produtoId = 1;
    const mockProduto: Produto = {
      id: 0,
      nome: '',
      categoria: '',
      disponivel: false,
      tempoPreparo: 0
    };

    service.update(mockProduto, produtoId).subscribe(produto => {
      expect(produto).toEqual(mockProduto);
    });

    const req = httpMock.expectOne(`${service.API}/${produtoId}`);
    expect(req.request.method).toBe('PUT');
    req.flush(mockProduto);
  });

  it('deve deletar um produto via DELETE', () => {
    const produtoId = 1;

    service.delete(produtoId).subscribe();

    const req = httpMock.expectOne(`${service.API}/${produtoId}`);
    expect(req.request.method).toBe('DELETE');
    req.flush(null);
  });
});
