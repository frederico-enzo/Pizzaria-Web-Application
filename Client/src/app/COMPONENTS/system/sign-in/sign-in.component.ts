import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { ClienteService } from 'src/app/SERVICE/cliente-service/cliente.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
  usuario: Cliente = new Cliente();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private clienteService: ClienteService
  ) {
    this.route.params.subscribe(params => {
      const clientId = params['id'];
    });
  }

  login() {
    this.clienteService.checkLogin(this.usuario.email, this.usuario.senha).subscribe(
      (cliente) => {
        if (cliente && this.usuario.email === 'admin') {
          this.router.navigate(['/admin']);
        } else if (cliente) {
          this.router.navigate(['/client', cliente.id]);
        } else {
          console.error('Cliente não encontrado.');
        }
      },
      (error) => {
        console.error('Erro ao fazer login:', error);
        alert('Erro ao fazer login. Tente novamente mais tarde.');
      }
    );
  }
}
