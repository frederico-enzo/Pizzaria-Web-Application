import { Atributo } from "../atributo-model/atributo";
import { Pedido } from "../pedido-model/pedido";
import { Produto } from "../produto-model/produto";
import { Sabor } from "../sabor-model/sabor";


export class Item {
    id!: number;
    produto!: Produto; 
    quantidade!: number;
    sabors!: Sabor[]; 
    atributoEspecifico!: Atributo;
    pedido!:Pedido
}
