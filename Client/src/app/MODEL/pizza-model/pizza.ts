import { Sabor } from "../sabor-model/sabor";

export class Pizza {
    id!: number;
    valor!: number;
    tamanho!: string;
    sabores!: Sabor[];
}