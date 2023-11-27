import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/SERVICE/login-service/login.service';
import { Login } from 'src/app/MODEL/login-model/login';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
  login: Login = new Login();

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {
    this.loginService.removeToken();
  }

  logar() {
    // Implemente a requisição aqui e coloque o token no localStorage
    this.loginService.logar(this.login).subscribe({
      next: (token) => {
        localStorage.setItem("token", token.token);
        this.router.navigate(['admin/pedido-adm']);
      },
      error: (erro) => {
        console.log(erro);
      }
    });
  }
}
