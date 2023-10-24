import { Component, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-cliente-dateils-interface',
  templateUrl: './cliente-dateils-interface.component.html',
  styleUrls: ['./cliente-dateils-interface.component.scss']
})
export class ClienteDateilsInterfaceComponent {
  model: Cliente = new Cliente();
  @Output() clienteRetornado = new EventEmitter<Cliente>();

  constructor(private route: ActivatedRoute, private service: ClienteService) {
    this. findbyId();
  }

  findbyId() {
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);

    if (id !== null) {
      const clientId = Number(id);
      this.service.findById(clientId).subscribe({
        next: cliente => {
          this.model = cliente;
          this.clienteRetornado.emit(cliente);
          console.log(cliente);
        },
        error: erro => {
          console.error(erro);
        }
      });
    }
  }
  
}
