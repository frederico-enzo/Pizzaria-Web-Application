import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';
import { EnderecoService } from 'src/app/SERVICE/endereco-service/endereco.service';

@Component({
  selector: 'app-endereco-details',
  templateUrl: './endereco-details.component.html',
  styleUrls: ['./endereco-details.component.scss']
})
export class EnderecoDetailsComponent {
  @Input() endereco: Endereco = new Endereco();
  @Output() retorno = new EventEmitter<Endereco>();

  service = inject(EnderecoService);
  constructor() {  }

  create() {

    this.service.create(this.endereco).subscribe({
      next: atributo => { // QUANDO DÁ CERTO
        this.retorno.emit(atributo);
      },
      error: erro => { // QUANDO DÁ ERRO
        console.error(erro);
      }
    });
  }

  update() {
    this.service.update(this.endereco, this.endereco.id).subscribe({
      next: endereco => { // QUANDO DÁ CERTO
        this.retorno.emit(endereco);
      },
      error: erro => { // QUANDO DÁ ERRO
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console!');
        console.error(erro);
      }
    });
  }

}
