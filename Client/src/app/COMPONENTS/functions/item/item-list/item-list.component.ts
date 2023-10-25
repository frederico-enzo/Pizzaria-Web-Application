import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Item } from 'src/app/MODEL/item-model/item';
import { ItemService } from 'src/app/SERVICE/item-service/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.scss']
})
export class ItemListComponent {
  lista: Item[] = []
  SelecionadaParaEdicao: Item = new Item();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private service: ItemService
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
    this.SelecionadaParaEdicao = new Item();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, item: Item, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, item);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(item: Item) {
    if (item.id === 0) {
      this.service.create(item).subscribe({
        next: produto => {
          this.lista.push(item);
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error('Erro ao criar a pessoa. Consulte o console para mais detalhes.');
          console.error(erro);
        }
      });
    } else {
      this.service.update(item, item.id).subscribe({
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
