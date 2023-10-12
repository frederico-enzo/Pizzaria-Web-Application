import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent {
  roteador = inject(Router);
  usuario: Cliente = new Cliente()
  login(){
    if(this.usuario.email ==="admin" && this.usuario.senha === "admin"){
      this.roteador.navigate(['/app'])
    }else{
      alert("Login incorreto!")
    }
  }

}
