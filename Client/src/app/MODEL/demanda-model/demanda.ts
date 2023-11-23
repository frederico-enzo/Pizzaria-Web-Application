import { Pedido } from "../pedido-model/pedido";
import { Produto } from "../produto-model/produto";
import { Propriedade } from "../propriedade-model/propriedade";
import { Sabor } from "../sabor-model/sabor";

export class Demanda {
    id!: number;
    produto!: Produto; 
    quantidade!: number;
    sabors!: Sabor[]; 
    propriedade!: Propriedade;
    pedido!:Pedido
}
