import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Item } from 'src/app/MODEL/item-model/item';
import { ItemService } from 'src/app/SERVICE/item-service/item.service';
import { ProdutoService } from 'src/app/SERVICE/produto-service/produto.service';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.scss']
})
export class ItemDetailsComponent {


  @Input() item: Item = new Item();
  @Output() retorno = new EventEmitter<Item>();

  service = inject(ItemService);
  constructor(private modalService : NgbModal) {  }

  create() {
    this.service.create(this.item).subscribe({
      next: item => { 
        this.retorno.emit(item);
        this.modalService.dismissAll();
      },
      error: erro => { 
        console.error(erro);
        if(erro.status < 400){
          this.modalService.dismissAll();
            window.location.reload();
        }
      }
    });
  }

  update() {
    this.service.update(this.item, this.item.id).subscribe({
      next: item => {
        this.retorno.emit(item);
        this.modalService.dismissAll();
        window.location.reload();
      },
      error: erro => { 
          if(erro.status < 400){
            this.modalService.dismissAll();
            window.location.reload();

          }
      }
    });
  }

}