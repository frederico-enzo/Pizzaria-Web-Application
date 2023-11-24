import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
  constructor(private modalService: NgbModal) { }

  create() {
    this.service.create(this.atributo).subscribe({
      next: atributo => {
        this.retorno.emit(atributo);
        window.location.reload();
        this.modalService.dismissAll();
      },
      error: erro => {
        if (erro.status < 400) {
          window.location.reload();
          this.modalService.dismissAll();
        }
      }
    });
  }

  update() {
    this.service.update(this.atributo, this.atributo.id).subscribe({
      next: atributo => {
        this.retorno.emit(atributo);
        window.location.reload();
        this.modalService.dismissAll();
      },
      error: erro => {
        if (erro.status < 400) {
          window.location.reload();
          this.modalService.dismissAll();
        }
      }
    });
  }

}
