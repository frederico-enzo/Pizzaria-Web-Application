import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent {
  model: Cliente = new Cliente();
  @Output() clienteRetornado = new EventEmitter<Cliente>();
  constructor(
    private route: ActivatedRoute,
    private modalService: NgbModal,
    private service: ClienteService
  ) {    this.findbyId() }

  salvarEdicao() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const clientId = Number(id);
      console.log(clientId);
      this.service.update(this.model, clientId).subscribe({
        next: atributo => { // QUANDO DÁ CERTO
          this.clienteRetornado.emit(atributo);
          this.modalService.dismissAll();
        },
        error: erro => { // QUANDO DÁ ERRO
          console.error(erro);
        }
      });
    }
  }

  findbyId() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id !== null) {
      const clientId = Number(id);
      this.service.findById(clientId).subscribe({
        next: cliente => {
          this.model = cliente;
          this.clienteRetornado.emit(cliente);
        },
        error: erro => {
          console.error(erro);
        }
      });
    }
  }
  editar(modal: any) {
    this.modalService.open(modal, { size: 'xd' });
  }

}
