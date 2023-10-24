import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.scss']
})
export class ProdutoListComponent {
  lista: Produto[] = []
  SelecionadaParaEdicao: Produto = new Produto();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private service: ProdutoService
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
    this.SelecionadaParaEdicao = new Produto();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, produto: Produto, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, produto);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(produto: Produto) {
    if (produto.id === 0) {
      this.service.create(produto).subscribe({
        next: produto => {
          this.lista.push(produto);
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error('Erro ao criar a pessoa. Consulte o console para mais detalhes.');
          console.error(erro);
        }
      });
    } else {
      this.service.update(produto, produto.id).subscribe({
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
