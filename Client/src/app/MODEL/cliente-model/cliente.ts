import { Endereco } from "../endereco-model/endereco";

export class Cliente {
    id!: number;
    nome!: string;
    telefone!: string;
    email!: string;
    senha!: string;
    endereco!: Endereco;
}
