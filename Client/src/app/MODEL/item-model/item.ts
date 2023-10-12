import { Atributo } from "../atributo-model/atributo";
import { Produto } from "../produto-model/produto";
import { Sabor } from "../sabor-model/sabor";
import { Pedido } from "../pedido-model/pedido";


export class Item {
    id!: number;
    pedido!: Pedido; 
    produto!: Produto; 
    quantidade!: number;
    sabors!: Sabor[]; 
    atributoEspecifico!: Atributo;
}
