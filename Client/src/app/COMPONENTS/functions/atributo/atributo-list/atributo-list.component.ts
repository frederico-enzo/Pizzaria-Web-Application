import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { AtributoService } from 'src/app/SERVICE/atributo-service/atributo.service';

@Component({
  selector: 'app-atributo-list',
  templateUrl: './atributo-list.component.html',
  styleUrls: ['./atributo-list.component.scss']
})
export class AtributoListComponent {
  lista: Atributo[] = []
  SelecionadaParaEdicao: Atributo = new Atributo();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private atributoService: AtributoService
  ) { this.listAll();  }

  delete(id: number) {
    this.atributoService.delete(id).subscribe({
      next: () => {
        console.error('Exclusão bem-sucedida!');
        this.listAll();
      },
      error: erro => {
        console.error('Erro ao excluir a pessoa. Consulte o console para mais detalhes.');
        console.error(erro);
      }
    });
  }
  listAll() {
    this.atributoService.listAll().subscribe({
      next: lista => {
        this.lista = lista;
      },
      error: erro => {
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console.');
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
    if (atributo.id === 0) {
      this.atributoService.create(atributo).subscribe({
        next: pessoaCriada => {
          this.lista.push(pessoaCriada);
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error('Erro ao criar a pessoa. Consulte o console para mais detalhes.');
          console.error(erro);
        }
      });
    } else {
      this.atributoService.update(atributo, atributo.id).subscribe({
        next: Atualizada => {
          this.lista[this.indiceSelecionadoParaEdicao] = Atualizada;
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error('Erro ao atualizar a pessoa. Consulte o console para mais detalhes.');
          console.error(erro);
        }
      });
    }
  }
}
