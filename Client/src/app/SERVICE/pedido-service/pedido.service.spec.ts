import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { PedidoService } from './pedido.service';

describe('PedidoService', () => {
  let service: PedidoService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [PedidoService],
    });

    service = TestBed.inject(PedidoService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });
  
  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
