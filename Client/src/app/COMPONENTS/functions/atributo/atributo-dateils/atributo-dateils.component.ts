import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { AtributoService } from 'src/app/SERVICE/atributo-service/atributo.service';

@Component({
  selector: 'app-atributo-dateils',
  templateUrl: './atributo-dateils.component.html',
  styleUrls: ['./atributo-dateils.component.scss']
})
export class AtributoDateilsComponent {
  @Input() atributo: Atributo = new Atributo();
  @Output() retorno = new EventEmitter<Atributo>();

  service = inject(AtributoService);
  constructor() {  }

  create() {

    this.service.create(this.atributo).subscribe({
      next: atributo => { // QUANDO DÁ CERTO
        this.retorno.emit(atributo);
      },
      error: erro => { // QUANDO DÁ ERRO
        console.error(erro);
      }
    });
  }

  update() {
    this.service.update(this.atributo, this.atributo.id).subscribe({
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
