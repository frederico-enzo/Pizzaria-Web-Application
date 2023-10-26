import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-cliente-details',
  templateUrl: './cliente-details.component.html',
  styleUrls: ['./cliente-details.component.scss']
})
export class ClienteDetailsComponent {
  @Input() enderecoId!: number;
  @Input() cliente: Cliente = new Cliente();
  @Output() retorno = new EventEmitter<Cliente>();
  mensagem !: string;
  sucesso : boolean = false;
  error : boolean = false;

  service = inject(ClienteService);
  constructor(private modalService: NgbModal) {  }

  create() {
    this.service.create(this.cliente).subscribe({
      next: cliente => { 
        this.mensagem = "Sucesso!";
        this.sucesso = true;
        this.retorno.emit(cliente);
        this.modalService.dismissAll();
      },
      error: erro => { 
        console.error(erro);
        if(erro.status < 400){

          this.modalService.dismissAll();
            window.location.reload();
        }
      }
    });
  }
  update() {
    // Verifique se o cliente tem um endereço associado
    if (this.enderecoId) {
      // Crie um objeto de endereço com o ID fornecido
      const novoEndereco = new Endereco();
      novoEndereco.id = this.enderecoId;
  
      // Atribua o novo endereço ao cliente
      this.cliente.endereco = novoEndereco;
    }
  
    this.service.update(this.cliente, this.cliente.id).subscribe({
      next: cliente => {
        this.retorno.emit(cliente);
        this.modalService.dismissAll();
        window.location.reload();
      },
      error: erro => { 
          if(erro.status < 400){
            this.modalService.dismissAll();
            window.location.reload();
          }
      }
    });
  }
  
}