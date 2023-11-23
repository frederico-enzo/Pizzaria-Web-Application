import { Cliente } from "../usuario-model/usuario";
import { Item } from "../item-model/item";

export class Pedido {
    id!: number;
    cliente!: Cliente; 
    valorTotal!: number;
    items!: Item[]; 
    ativo!:boolean;
  }