import { Endereco } from '../endereco-model/endereco';
import { Cliente } from './cliente';

describe('Cliente', () => {

  it('should create an instance', () => {
    expect(new Cliente()).toBeTruthy();
  });


  let cliente: Cliente;

  beforeEach(() => {
    cliente = new Cliente();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    cliente.id = id;
    expect(cliente.id).toEqual(id);
  });

  it('deve inicializar username corretamente', () => {
    const username = 'joao123';
    cliente.username = username;
    expect(cliente.username).toEqual(username);
  });

  it('deve inicializar password corretamente', () => {
    const password = 'senha123';
    cliente.password = password;
    expect(cliente.password).toEqual(password);
  });

  it('deve inicializar token corretamente', () => {
    const token = 'token123';
    cliente.token = token;
    expect(cliente.token).toEqual(token);
  });

  it('deve inicializar endereco corretamente', () => {
    const endereco: Endereco = {
      id: 0,
      rua: '',
      bairro: '',
      numero: '',
      cep: 0
    };
    cliente.endereco = endereco;
    expect(cliente.endereco).toEqual(endereco);
  });
});


