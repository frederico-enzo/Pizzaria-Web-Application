import { Atributo } from '../atributo-model/atributo';
import { Cliente } from '../cliente-model/cliente';
import { Pedido } from '../pedido-model/pedido';
import { Produto } from '../produto-model/produto';
import { Sabor } from '../sabor-model/sabor';
import { Item } from './item';

describe('Item', () => {
  it('should create an instance', () => {
    expect(new Item()).toBeTruthy();
  });
  let item: Item;

  beforeEach(() => {
    item = new Item();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    item.id = id;
    expect(item.id).toEqual(id);
  });

  it('deve inicializar produto corretamente', () => {
    const produto: Produto = {
      id: 0,
      nome: '',
      categoria: '',
      disponivel: false,
      tempoPreparo: 0
    };
    item.produto = produto;
    expect(item.produto).toEqual(produto);
  });

  it('deve inicializar quantidade corretamente', () => {
    const quantidade = 2;
    item.quantidade = quantidade;
    expect(item.quantidade).toEqual(quantidade);
  });

  it('deve inicializar sabores corretamente', () => {
    const sabores: Sabor[] = [
    ];
    item.sabors = sabores;
    expect(item.sabors).toEqual(sabores);
  });

  it('deve inicializar atributoEspecifico corretamente', () => {
    const atributoEspecifico: Atributo = {
      id: 0,
      tamanho: '',
      descricao: '',
      preco: 0
    };
    item.atributoEspecifico = atributoEspecifico;
    expect(item.atributoEspecifico).toEqual(atributoEspecifico);
  });

  it('deve inicializar pedido corretamente', () => {
    const pedido: Pedido = {
      id: 0,
      cliente: new Cliente,
      valorTotal: 0,
      items: [],
      ativo: false
    };
    item.pedido = pedido;
    expect(item.pedido).toEqual(pedido);
  });


});
