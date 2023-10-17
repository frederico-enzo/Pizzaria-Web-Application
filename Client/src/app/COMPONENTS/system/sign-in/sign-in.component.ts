import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
  constructor(private router: Router, private clienteService: ClienteService, ) {}
  usuario: Cliente = new Cliente();

  login() {
    this.clienteService.checkLogin(this.usuario.email, this.usuario.senha)
      .subscribe(
        (cliente) => {
          if (cliente) {
            this.router.navigate(['/app']);
          } else {
            alert("Credenciais incorretas!");
          }
        },
        (error) => {
          console.error('Erro ao fazer login:', error);
          alert('Erro ao fazer login. Tente novamente mais tarde.');
        }
      );
  }
}