import { Component, Input, Output } from '@angular/core';

@Component({
  selector: 'app-atributo-dateils',
  templateUrl: './atributo-dateils.component.html',
  styleUrls: ['./atributo-dateils.component.scss']
})
export class AtributoDateilsComponent {
  @Input() pessoa: Pessoa = new Pessoa();
  @Output() retorno = new EventEmitter<Pessoa>();

  pessoaService = inject(PessoaService);
}
