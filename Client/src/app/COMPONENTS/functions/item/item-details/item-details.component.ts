import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { Cliente } from 'src/app/MODEL/cliente-model/cliente';
import { Item } from 'src/app/MODEL/item-model/item';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';
import { Tamanho } from 'src/app/MODEL/tamanho-enum/tamanho';
import { AtributoService } from 'src/app/SERVICE/atributo-service/atributo.service';
import { ItemService } from 'src/app/SERVICE/item-service/item.service';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';
import { SaborService } from 'src/app/SERVICE/sabor-service/sabor.service';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.scss']
})
export class ItemDetailsComponent {
  produtos: Produto[] = [];
  sabores: Sabor[] = [];
  atributos: Atributo[] = [];


  @Input() pedidoId: number | undefined;
  @Input() item: Item = new Item();
  @Output() retorno = new EventEmitter<Item>();




  mensagem !: string;
  sucesso: boolean = false;
  error: boolean = false;

  service = inject(ItemService);
  serviceProduto = inject(ProdutoService);
  serviceSabor = inject(SaborService);
  atributoService = inject(AtributoService);


  constructor(private modalService: NgbModal) {
    this.listAllProduto();
    this.listAllSabores();
    this.listAllTamanho();
  }

  create() {
    if (this.pedidoId) {
      const novoCLieten = new Pedido();
      novoCLieten.id = this.pedidoId;
      this.item.pedido = novoCLieten;
    }
    this.service.create(this.item).subscribe({
      next: item => {
        this.mensagem = "Sucesso!";
        this.sucesso = true;
        this.retorno.emit(item);
        this.modalService.dismissAll();
      },
      error: erro => {
        console.error(erro);
        if (erro.status < 400) {
          this.modalService.dismissAll();
          window.location.reload();
        }
      }
    });
  }
  
  listAllProduto() {
    this.serviceProduto.listAll().subscribe({
      next: lista => {
        this.produtos = lista;
        console.log(this.produtos);
      },
      error: erro => {
        console.error(erro);
      }
    });
  }
  listAllSabores() {
    this.serviceSabor.listAll().subscribe({
      next: lista => {
        this.sabores = lista;
      },
      error: erro => {
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console.');
        console.error(erro);
      }
    });
  }
  listAllTamanho() {
    this.atributoService.listAll().subscribe({
      next: lista => {
        this.atributos = lista;
      },
      error: erro => {
        alert('Exemplo de tratamento de erro/exception! Observe o erro no console.');
        console.error(erro);
      }
    });
  }

}