import { Component } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';
import { SaborService } from 'src/app/SERVICE/sabor-service/sabor.service';

@Component({
  selector: 'app-sabor-list',
  templateUrl: './sabor-list.component.html',
  styleUrls: ['./sabor-list.component.scss']
})
export class SaborListComponent {
  lista: Sabor[] = []
  SelecionadaParaEdicao: Sabor = new Sabor();
  indiceSelecionadoParaEdicao!: number;

  constructor(
    private modalService: NgbModal,
    private service: SaborService
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
    this.SelecionadaParaEdicao = new Sabor();
    this.modalService.open(modal, { size:  'xd'});
  }

  editar(modal: any, sabor: Sabor, indice: number) {
    this.SelecionadaParaEdicao = Object.assign({}, sabor);
    this.indiceSelecionadoParaEdicao = indice;
    this.modalService.open(modal, { size: 'xd' });
  }
  addOuEditar(sabor: Sabor) {
    if (sabor.id === 0) {
      this.service.create(sabor).subscribe({
        next: castrada => {
          this.lista.push(castrada);
          this.modalService.dismissAll();
        },
        error: erro => {
          console.error('Erro ao criar a pessoa. Consulte o console para mais detalhes.');
          console.error(erro);
        }
      });
    } else {
      this.service.update(sabor, sabor.id).subscribe({
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
