import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { PedidoService } from 'src/app/SERVICE/pedido-service/pedido.service';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';

@Component({
  selector: 'app-produto-list-interface',
  templateUrl: './produto-list-interface.component.html',
  styleUrls: ['./produto-list-interface.component.scss']
})
export class ProdutoListInterfaceComponent {
  pedidoModel: Pedido = new Pedido();

  lista: Produto[] = []


  constructor(
    private pedidoService: PedidoService,
    private modalService: NgbModal,
    private service: ProdutoService
  ) { this.listAll(); }

  
    open(modal: any) {
      this.modalService.open(modal, { size: 'xd' });
    }

  salvarPedido() {
    this.pedidoService.create(this.pedidoModel).subscribe(
      (pedidoCriado: Pedido) => {
        console.log('Pedido criado:', pedidoCriado);
        // Lógica adicional, como redirecionar para outra página
      },
      (erro) => {
        console.error('Erro ao criar pedido:', erro);
      }
    );
  }
  listAll() {
    this.service.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console.');
        console.error(erro);
      }
    });
  }
}
