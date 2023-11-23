import { Endereco } from "../endereco-model/endereco";

export class User {
    id!: number;
    login!: string;
    role!: string;
    password!: string;
    endereco!: Endereco;
    token!:String;
}
