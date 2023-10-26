import { Component, afterNextRender, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.scss']
})
export class ClienteListComponent {

  lista: Cliente[] = [];
  find : Cliente = new Cliente;


  SelecionadoParaEdicao: Cliente = new Cliente();
  indiceSelecionadoParaEdicao!: number;

  modalService = inject(NgbModal);
  service = inject(ClienteService);

  constructor() {
    this.listAll();
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
  
  findById(id: number) {
    this.service.findById(id).subscribe({
      next: cliente => {
        this.find = cliente;
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
    this.SelecionadoParaEdicao = new Cliente();
    this.modalService.open(modal, { size:  'lg'});
  }
  editar(modal: any, cliente: Cliente, indice: number) {
    this.SelecionadoParaEdicao = Object.assign({}, cliente);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'lg' });
  }
  addOuEditar(cliente: Cliente) {
    this.listAll();
    this.modalService.dismissAll();
  }


  
}
