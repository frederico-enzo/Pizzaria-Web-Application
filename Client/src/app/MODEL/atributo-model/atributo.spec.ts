import { Atributo } from './atributo';

describe('Atributo', () => {
  let atributo: Atributo;

  beforeEach(() => {
    atributo = new Atributo();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    atributo.id = id;
    expect(atributo.id).toEqual(id);
  });

  it('deve inicializar tamanho corretamente', () => {
    const tamanho = 'Médio';
    atributo.tamanho = tamanho;
    expect(atributo.tamanho).toEqual(tamanho);
  });

  it('deve inicializar descricao corretamente', () => {
    const descricao = 'Descrição do produto';
    atributo.descricao = descricao;
    expect(atributo.descricao).toEqual(descricao);
  });

  it('deve inicializar preco corretamente', () => {
    const preco = 15.99;
    atributo.preco = preco;
    expect(atributo.preco).toEqual(preco);
  });
  

});
