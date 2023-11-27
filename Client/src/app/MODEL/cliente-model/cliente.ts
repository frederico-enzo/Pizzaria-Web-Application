import { Endereco } from "../endereco-model/endereco";

export class Cliente {
    id!: number;
    username!: string;
    password!: string;
    token!:string;
    endereco!: Endereco;
}
