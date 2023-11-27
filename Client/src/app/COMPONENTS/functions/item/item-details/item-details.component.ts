import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Atributo } from 'src/app/MODEL/atributo-model/atributo';
import { Item } from 'src/app/MODEL/item-model/item';
import { Pedido } from 'src/app/MODEL/pedido-model/pedido';
import { Produto } from 'src/app/MODEL/produto-model/produto';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';
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

  quantidadeDeSabores(item: Item) {
    const maxSabores: number = this.getMaxSabores(item.atributoEspecifico.tamanho);

    if (item.sabors.length > maxSabores) {
      this.mensagem = "Erro!";
      this.error = true;
      setTimeout(() => {
        this.error = false;
      }, 1000);
      throw new Error(`O tamanho ${item.atributoEspecifico.tamanho} permite somente ${maxSabores} sabores.`);
    } else{
      this.modalService.dismissAll();
    } 
  }

  getMaxSabores(tamanho: String): number {
    switch (tamanho) {
      case 'GIGANTE':
        return 4;
      case 'GRANDE':
      case 'MEDIA':
        return 3;
      case 'PEQUENO':
        return 2;
      default:
        return 0;
    }
  }

  create() {
    if (this.pedidoId) {
      const novoCliente = new Pedido();
      novoCliente.id = this.pedidoId;
      this.item.pedido = novoCliente;
    }

    try {
      this.quantidadeDeSabores(this.item); 
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
            this.mensagem = "Erro!";
            this.error = true;
            setTimeout(() => {
              this.error = false;
            }, 1000);
          } else {
            this.modalService.dismissAll();
          }
        }
      });
    } catch (error) {
      console.error(error);
      this.mensagem = "Erro!";
      setTimeout(() => {
        this.error = false;
      }, 1000);
    }
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