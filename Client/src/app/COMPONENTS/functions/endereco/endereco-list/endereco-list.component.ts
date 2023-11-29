import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';
import { EnderecoService } from 'src/app/SERVICE/endereco-service/endereco.service';

@Component({
  selector: 'app-endereco-list',
  templateUrl: './endereco-list.component.html',
  styleUrls: ['./endereco-list.component.scss']
})
export class EnderecoListComponent {
  lista: Endereco[] = []
  SelecionadaParaEdicao: Endereco = new Endereco();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private service: EnderecoService
  ) { this.listAll();  }

  delete(id: number) {
    this.service.delete(id).subscribe({
      next: () => {
        this.listAll();
      },
      error: erro => {
        console.error(erro);
      }
    });
  }
  listAll() {
    this.service.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        console.error(erro);
      }
    });
  }

  adicionar(modal: any) {
    this.SelecionadaParaEdicao = new Endereco();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, atributo: Endereco, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, atributo);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(endereco: Endereco) {
    this.listAll();
    this.modalService.dismissAll();
  }
}
