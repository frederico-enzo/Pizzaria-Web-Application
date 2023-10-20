import { Component } from '@angular/core';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {

  constructor(private clienteService: ClienteService) { }
  usuario: Cliente = new Cliente();

  singup() {
    this.clienteService.create(this.usuario).subscribe(
      (cliente) => {
        this.usuario = new Cliente();
        console.log('Cliente cadastrado com sucesso:'+ this.usuario, cliente);
      },
      (error) => {
        console.error('Erro ao cadastrar cliente:', error);
      }
    );
  }


  }
