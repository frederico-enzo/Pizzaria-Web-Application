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
  find : Pedido = new Pedido;

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

  go(id: number) {
    this.service.find(id).subscribe({
      next: cliente => {
        this.find = cliente;
        console.log(this.find);
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


  
}
