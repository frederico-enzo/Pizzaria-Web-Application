import { Component, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { AtributoService } from 'src/app/SERVICE/atributo-service/atributo.service';

@Component({
  selector: 'app-atributo-list',
  templateUrl: './atributo-list.component.html',
  styleUrls: ['./atributo-list.component.scss']
})
export class AtributoListComponent {
  [x: string]: any;
  lista: Atributo[] = []
  SelecionadaParaEdicao: Atributo = new Atributo();
  indiceSelecionadoParaEdicao!: number;
  modalService = inject(NgbModal);

  constructor(
    private atributoService: AtributoService
  ) { this.listAll();  }

  delete(id: number) {
    this.atributoService.delete(id).subscribe({
      next: () => {
        this.listAll();
      },
      error: erro => {
      }
    });
  }
  listAll() {
    this.atributoService.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  adicionar(modal: any) {
    this.SelecionadaParaEdicao = new Atributo();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, atributo: Atributo, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, atributo);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(atributo: Atributo) {
      this.listAll();
      this.modalService.dismissAll();
  }
}
