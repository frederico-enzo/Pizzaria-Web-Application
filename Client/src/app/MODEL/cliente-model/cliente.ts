import { Endereco } from "../endereco-model/endereco";

export class Cliente {
    id!: Number;
    nome!: String;
    telefone!: String;
    email!: String;
    senha!: String;
    endereco!: Endereco;
}
