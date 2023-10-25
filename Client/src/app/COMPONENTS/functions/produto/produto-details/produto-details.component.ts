import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';

@Component({
  selector: 'app-produto-details',
  templateUrl: './produto-details.component.html',
  styleUrls: ['./produto-details.component.scss']
})
export class ProdutoDetailsComponent {
  mensagem !: string;
  error: boolean = false;

  @Input() produto: Produto = new Produto();
  @Output() retorno = new EventEmitter<Produto>();

  service = inject(ProdutoService);
  constructor(private modalService : NgbModal) {  }

   create() {
    this.service.create(this.produto).subscribe({
      next: produto => {
        this.retorno.emit(produto);
        this.modalService.dismissAll();
      },
      error: erro => {
        console.error(erro);
        if (erro.status < 400) {
          this.modalService.dismissAll();
          window.location.reload();
        } else {
          this.mensagem = "Erro!";
          this.error = true;
          setTimeout(() => {
            this.error = false;
          }, 1000);
        }
      }
    });
  }
  update() {
    this.service.update(this.produto, this.produto.id).subscribe({
      next: produto => {
        this.retorno.emit(produto);
        this.modalService.dismissAll();
        window.location.reload();
      },
      error: erro => {
        console.error(erro);
        if (erro.status < 400) {
          this.modalService.dismissAll();
          window.location.reload();
        } else {
          this.mensagem = "Erro!";
          this.error = true;
          setTimeout(() => {
            this.error = false;
          }, 1000);
        }
      }
    });
  }
}