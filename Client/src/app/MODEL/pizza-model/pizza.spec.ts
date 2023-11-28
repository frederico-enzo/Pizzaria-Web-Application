import { Pizza } from './pizza';
import { Sabor } from '../sabor-model/sabor';

describe('Pizza', () => {
  let pizza: Pizza;

  beforeEach(() => {
    pizza = new Pizza();
  });

  it('deve ser criado', () => {
    expect(pizza).toBeTruthy();
  });

  it('deve ter a propriedade "id"', () => {
    pizza.id = 1;
    expect(pizza.id).toEqual(1);
  });

  it('deve ter a propriedade "valor"', () => {
    pizza.valor = 15.99;
    expect(pizza.valor).toEqual(15.99);
  });

  it('deve ter a propriedade "tamanho"', () => {
    pizza.tamanho = 'Grande';
    expect(pizza.tamanho).toEqual('Grande');
  });

  it('deve ter a propriedade "sabores"', () => {
    const sabor1 = new Sabor();
    sabor1.id = 1;
    sabor1.nome = 'Calabresa';

    const sabor2 = new Sabor();
    sabor2.id = 2;
    sabor2.nome = 'Margherita';

    pizza.sabores = [sabor1, sabor2];

    expect(pizza.sabores).toEqual([sabor1, sabor2]);
  });
});
