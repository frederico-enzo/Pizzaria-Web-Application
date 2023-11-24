import { Cliente } from "../cliente-model/cliente";
import { Item } from "../item-model/item";

export class Pedido {
    id!: number;
    cliente!: Cliente; 
    valorTotal!: number;
    items!: Item[]; 
    ativo!:boolean;
  }