import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-cliente-details',
  templateUrl: './cliente-details.component.html',
  styleUrls: ['./cliente-details.component.scss']
})
export class ClienteDetailsComponent {
  @Input() clienteId: number = 0;
  @Input() cliente: Cliente = new Cliente();
  @Output() retorno = new EventEmitter<Cliente>();
  mensagem !: string;
  error: boolean = false;

  service = inject(ClienteService);
  constructor(private modalService: NgbModal) { }

  create() {
    this.service.create(this.cliente).subscribe({
      next: cliente => {
        this.retorno.emit(cliente);
        this.modalService.dismissAll();
      },
      error: erro => {
        console.error(erro);
        if (erro.status < 400) {
          this.modalService.dismissAll();
          window.location.reload();
        } else {
          this.mensagem = "Erro!";
          this.error = true;
          setTimeout(() => {
            this.error = false;
          }, 1000);
        }
      }
    });
  }
  update() {
    this.service.update(this.cliente, this.cliente.id).subscribe({
      next: cliente => {
        this.retorno.emit(cliente);
        this.modalService.dismissAll();
        window.location.reload();
      },
      error: erro => {
        console.error(erro);
        if (erro.status < 400) {
          this.modalService.dismissAll();
          window.location.reload();
        } else {
          this.mensagem = "Erro!";
          this.error = true;
          setTimeout(() => {
            this.error = false;
          }, 1000);
        }
      }
    });
  }
}