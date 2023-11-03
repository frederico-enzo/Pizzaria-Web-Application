import { Component, inject } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.scss']
})
export class ClienteListComponent {

  constructor(){
    this.findAll();
  }

  lista: Cliente[] = [];
  
  modalService = inject(NgbModal);
  modalRef!: NgbModalRef;
  service = inject(ClienteService);

  index!: number;
  select!: Cliente;
  entity!: Cliente;

  open(modal: any){
    this.modalRef = this.modalService.open(modal, {size: 'lg'});
  }

  post(modal: any){
    this.select = new Cliente();
    this.index = -1;
    this.modalRef = this.modalService.open(modal, {size: 'lg'});
  }

  put(modal: any, cliente: Cliente, i: number) {
    this.select = Object.assign({}, cliente);
    this.index = i;
    this.modalRef = this.modalService.open(modal, {size: 'lg'});
  }

  delete(id: number) {
    this.service.delete(id).subscribe({
      next: () => {
        this.findAll();
      }, error: erro => {
        console.error(erro);
      }
    });
  }

  findById(id: number) {
    this.service.findById(id).subscribe({
      next: cliente => {
        this.entity = cliente;
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  addOuEdt(cliente: Cliente) {
    this.findAll();
    this.modalService.dismissAll();
  }

  findAll(){
    this.service.findAll().subscribe({
      next: lista => {
        this.lista = lista;
      }, error: erro => {
        console.log(erro);
      }
    });
  }
  
}
