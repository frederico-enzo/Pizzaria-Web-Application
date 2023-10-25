import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
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

  service = inject(ClienteService);
  constructor() {  }

  create() {

    this.service.create(this.cliente).subscribe({
      next: atributo => { // QUANDO DÁ CERTO
        this.retorno.emit(atributo);
      },
      error: erro => { // QUANDO DÁ ERRO
        console.error(erro);
      }
    });
  }

  update() {
    this.service.update(this.cliente, this.cliente.id).subscribe({
      next: atributo => { // QUANDO DÁ CERTO
        this.retorno.emit(atributo);
      },
      error: erro => { // QUANDO DÁ ERRO
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
        console.error(erro);
      }
    });
  }
}