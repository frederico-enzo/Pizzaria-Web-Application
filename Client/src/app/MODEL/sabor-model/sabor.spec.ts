import { Sabor } from './sabor';

describe('Sabor', () => {
  it('should create an instance', () => {
    expect(new Sabor()).toBeTruthy();
  });
  let sabor: Sabor;

  beforeEach(() => {
    sabor = new Sabor();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    sabor.id = id;
    expect(sabor.id).toEqual(id);
  });

  it('deve inicializar nome corretamente', () => {
    const nome = 'Calabresa';
    sabor.nome = nome;
    expect(sabor.nome).toEqual(nome);
  });

  it('deve inicializar componentes corretamente', () => {
    const componentes = ['Calabresa', 'Cebola', 'Molho de Tomate'];
    sabor.componentes = componentes;
    expect(sabor.componentes).toEqual(componentes);
  });
});
