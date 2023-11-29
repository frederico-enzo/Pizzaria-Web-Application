import { Funcionario } from './funcionario';

describe('Funcionario', () => {
  let funcionario: Funcionario;

  beforeEach(() => {
    funcionario = new Funcionario();
  });

  it('deve ser criado', () => {
    expect(funcionario).toBeTruthy();
  });

  it('deve permitir atribuir valores às propriedades', () => {
    funcionario.id = 1;
    funcionario.nome = 'John Doe';
    funcionario.idade = 30;
    funcionario.cpf = '123.456.789-01';
    funcionario.email = 'john.doe@example.com';
    funcionario.senha = 'senha123';
    funcionario.telefone = '123456789';

    expect(funcionario.id).toBe(1);
    expect(funcionario.nome).toBe('John Doe');
    expect(funcionario.idade).toBe(30);
    expect(funcionario.cpf).toBe('123.456.789-01');
    expect(funcionario.email).toBe('john.doe@example.com');
    expect(funcionario.senha).toBe('senha123');
    expect(funcionario.telefone).toBe('123456789');
  });
});
