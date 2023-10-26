import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { PedidoService } from 'src/app/SERVICE/pedido-service/pedido.service';


@Component({
  selector: 'app-pedido-details',
  templateUrl: './pedido-details.component.html',
  styleUrls: ['./pedido-details.component.scss']
})
export class PedidoDetailsComponent {

  @Input() clienteId!: number;
  @Input() pedido: Pedido = new Pedido();
  @Output() retorno = new EventEmitter<Pedido>();
  mensagem !: string;
  sucesso : boolean = false;
  error : boolean = false;

  service = inject(PedidoService);
  constructor(private modalService: NgbModal) {  }

  create() {
    if (this.clienteId) {
      // Crie um objeto de endereço com o ID fornecido
      const novoCliente = new Cliente();
      novoCliente.id = this.clienteId;
  
      // Atribua o novo endereço ao cliente
      this.pedido.cliente = novoCliente;
    }
    this.service.create(this.pedido).subscribe({
      next: pedido => { 
        this.mensagem = "Sucesso!";
        this.sucesso = true;
        this.retorno.emit(pedido);
        this.modalService.dismissAll();
      },
      error: erro => { 
        console.error(erro);
        if(erro.status < 400){
          this.mensagem = "Erro!";
          this.sucesso = true;
          this.modalService.dismissAll();
            window.location.reload();
        }
      }
    });
  }

}