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
    this.service.listAll().subscribe({
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
    this.SelecionadaParaEdicao = new Endereco();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, atributo: Endereco, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, atributo);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(endereco: Endereco) {
    if (endereco.id === 0) {
      this.service.create(endereco).subscribe({
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
      this.service.update(endereco, endereco.id).subscribe({
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
