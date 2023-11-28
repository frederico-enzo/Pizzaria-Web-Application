import { Produto } from './produto';

describe('Produto', () => {
  it('should create an instance', () => {
    expect(new Produto()).toBeTruthy();
  });
  let produto: Produto;

  beforeEach(() => {
    produto = new Produto();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    produto.id = id;
    expect(produto.id).toEqual(id);
  });

  it('deve inicializar nome corretamente', () => {
    const nome = 'Pizza Margherita';
    produto.nome = nome;
    expect(produto.nome).toEqual(nome);
  });

  it('deve inicializar categoria corretamente', () => {
    const categoria = 'Pizzas';
    produto.categoria = categoria;
    expect(produto.categoria).toEqual(categoria);
  });

  it('deve inicializar disponivel corretamente', () => {
    const disponivel = true;
    produto.disponivel = disponivel;
    expect(produto.disponivel).toEqual(disponivel);
  });

  it('deve inicializar tempoPreparo corretamente', () => {
    const tempoPreparo = 30;
    produto.tempoPreparo = tempoPreparo;
    expect(produto.tempoPreparo).toEqual(tempoPreparo);
  });
});
