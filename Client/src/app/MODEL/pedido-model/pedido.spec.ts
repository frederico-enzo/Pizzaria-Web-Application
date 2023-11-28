import { Cliente } from '../cliente-model/cliente';
import { Endereco } from '../endereco-model/endereco';
import { Item } from '../item-model/item';
import { Pedido } from './pedido';

describe('Pedido', () => {
  it('should create an instance', () => {
    expect(new Pedido()).toBeTruthy();
  });
  let pedido: Pedido;

  beforeEach(() => {
    pedido = new Pedido();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    pedido.id = id;
    expect(pedido.id).toEqual(id);
  });

  it('deve inicializar cliente corretamente', () => {
    const cliente: Cliente = {
      id: 0,
      username: '',
      password: '',
      token: '',
      endereco: new Endereco
    };
    pedido.cliente = cliente;
    expect(pedido.cliente).toEqual(cliente);
  });

  it('deve inicializar valorTotal corretamente', () => {
    const valorTotal = 50.99;
    pedido.valorTotal = valorTotal;
    expect(pedido.valorTotal).toEqual(valorTotal);
  });

  it('deve inicializar items corretamente', () => {
    const items: Item[] = [
      // Mockar alguns items se necessário
    ];
    pedido.items = items;
    expect(pedido.items).toEqual(items);
  });

  it('deve inicializar ativo corretamente', () => {
    const ativo = true;
    pedido.ativo = ativo;
    expect(pedido.ativo).toEqual(ativo);
  });
});
