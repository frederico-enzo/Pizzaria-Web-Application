import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { PedidoService } from 'src/app/SERVICE/pedido-service/pedido.service';

@Component({
  selector: 'app-pedido-list',
  templateUrl: './pedido-list.component.html',
  styleUrls: ['./pedido-list.component.scss']
})
export class PedidoListComponent {
  lista: Pedido[] = []
  SelecionadaParaEdicao: Pedido = new Pedido();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private service: PedidoService
  ) { this.listAll();
    }

  delete(id: number) {
    this.service.delete(id).subscribe({
      next: () => {
        console.error('Exclusão bem-sucedida!');
        this.listAll();
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  findbyId(id: number) {
    this.service.find(id).subscribe({
      next: () => {
        console.error('Exclusão bem-sucedida!');
        this.listAll();
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
    this.SelecionadaParaEdicao = new Pedido();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, Pedido: Pedido, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, Pedido);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(Pedido: Pedido) {
    if (Pedido.id === 0) {
      this.service.create(Pedido).subscribe({
        next: pessoaCriada => {
          this.lista.push(pessoaCriada);
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error(erro);
        }
      });
    } else {
      this.service.update(Pedido, Pedido.id).subscribe({
        next: Atualizada => {
          this.lista[this.indiceSelecionadoParaEdicao] = Atualizada;
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error(erro);
        }
      });
    }
  }
}
