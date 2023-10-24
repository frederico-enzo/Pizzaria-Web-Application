import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Sabor } from 'src/app/MODEL/sabor-model/sabor';
import { SaborService } from 'src/app/SERVICE/sabor-service/sabor.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-sabor-details',
  templateUrl: './sabor-details.component.html',
  styleUrls: ['./sabor-details.component.scss']
})
export class SaborDetailsComponent {
  @Input() sabor: Sabor = new Sabor();
  @Output() retorno = new EventEmitter<Sabor>();
  componenteEmEdicao: number | null = null;
  service = inject(SaborService);
  constructor(    private modalService: NgbModal,) {  }

  addComponente(componente: string, inputElement: HTMLInputElement  ) {
    if (!this.sabor.componentes) {
      this.sabor.componentes = []; 
    }
    this.sabor.componentes.push(componente);
    inputElement.value = '';
  }
  editarComponente(index: number) {
    this.componenteEmEdicao = index;
  }

  salvarComponente(index: number) {
    this.componenteEmEdicao = null;
  }

  cancelarEdicao() {
    this.componenteEmEdicao = null;
  }

  removerComponente(index: number) {
    this.sabor.componentes.splice(index, 1);
  }

  alternarModoEdicao() {
    this.componenteEmEdicao = null;
  }
  create() {
    this.service.create(this.sabor).subscribe({
      next: sabor => { 
        this.retorno.emit(sabor);
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
    this.service.update(this.sabor, this.sabor.id).subscribe({
      next: sabor => {
        this.retorno.emit(sabor);
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
