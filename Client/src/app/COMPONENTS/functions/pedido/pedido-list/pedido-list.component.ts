import { Component, ViewChild, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { PedidoService } from 'src/app/SERVICE/pedido-service/pedido.service';
import { ItemDetailsComponent } from '../../item/item-details/item-details.component';

@Component({
  selector: 'app-pedido-list',
  templateUrl: './pedido-list.component.html',
  styleUrls: ['./pedido-list.component.scss']
})
export class PedidoListComponent {
  

  lista: Pedido[] = [];
  pedido : Pedido = new Pedido;

  selectedPedidoId: number | undefined; 
  SelecionadoParaEdicao: Pedido = new Pedido();
  indiceSelecionadoParaEdicao!: number;

  service = inject(PedidoService);

  constructor(private modalService: NgbModal) {
    this.listAll();
  }
  selectPedido(pedidoId: number) {
    this.selectedPedidoId = pedidoId;
  }
  
  delete(id: number) {
    this.service.delete(id).subscribe({
      next: () => {
        this.listAll();
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  go(id: number) {
    this.service.find(id).subscribe({
      next: pedido => {
        this.pedido = pedido;
        console.log(this.pedido);
  
        if (this.pedido && this.pedido.items) {
          this.pedido.valorTotal = this.pedido.items.reduce((total, item) => {
            return total + item.atributoEspecifico.preco * item.quantidade;
          }, 0);
        }
      },
      error: erro => {
        console.error(erro);
      }
    });
  }
  

  listAll() {
    this.service.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  adicionar(modal: any) {
    this.SelecionadoParaEdicao = new Pedido();
    this.modalService.open(modal, { size:  'lg'});
  }
  editar(modal: any, pedido: Pedido, indice: number) {
    this.SelecionadoParaEdicao = Object.assign({}, pedido);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'lg' });
  }
  addOuEditar(pedido: Pedido) {
    this.listAll();
    this.modalService.dismissAll();
  }

  ir(modal: any) {
    this.SelecionadoParaEdicao = new Pedido();
    this.modalService.open(modal, { size:  'xl'});
  }
  
}
