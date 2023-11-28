import { Endereco } from './endereco';

describe('Endereco', () => {
  it('should create an instance', () => {
    expect(new Endereco()).toBeTruthy();
  });
  let endereco: Endereco;

  beforeEach(() => {
    endereco = new Endereco();
  });

  it('deve inicializar id corretamente', () => {
    const id = 1;
    endereco.id = id;
    expect(endereco.id).toEqual(id);
  });

  it('deve inicializar rua corretamente', () => {
    const rua = 'Rua ABC';
    endereco.rua = rua;
    expect(endereco.rua).toEqual(rua);
  });

  it('deve inicializar bairro corretamente', () => {
    const bairro = 'Centro';
    endereco.bairro = bairro;
    expect(endereco.bairro).toEqual(bairro);
  });

  it('deve inicializar numero corretamente', () => {
    const numero = '123';
    endereco.numero = numero;
    expect(endereco.numero).toEqual(numero);
  });

  it('deve inicializar cep corretamente', () => {
    const cep = 12345678;
    endereco.cep = cep;
    expect(endereco.cep).toEqual(cep);
  });

});
