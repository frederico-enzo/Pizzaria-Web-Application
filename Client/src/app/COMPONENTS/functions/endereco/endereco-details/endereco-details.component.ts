import { Component, EventEmitter, Input, Output, inject } from '@angular/core';
import { Endereco } from 'src/app/MODEL/endereco-model/endereco';
import { EnderecoService } from 'src/app/SERVICE/endereco-service/endereco.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-endereco-details',
  templateUrl: './endereco-details.component.html',
  styleUrls: ['./endereco-details.component.scss']
})
export class EnderecoDetailsComponent {
  @Input() endereco: Endereco = new Endereco();
  @Output() retorno = new EventEmitter<Endereco>();
  mensagem !: string;
  error: boolean = false;

  service = inject(EnderecoService);
  constructor(private modalService: NgbModal) { }

  create() {
    this.service.create(this.endereco).subscribe({
      next: endereco => {
        this.retorno.emit(endereco);
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
    this.service.update(this.endereco, this.endereco.id).subscribe({
      next: endereco => {
        this.retorno.emit(endereco);
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