import { Login } from "./login";

describe('Login', () => {
  it('deve ser criado', () => {
    const login = new Login();
    expect(login).toBeTruthy();
  });

  it('deve ter as propriedades "username" e "password"', () => {
    const login = new Login();
    login.username = 'testuser';
    login.password = 'testpassword';
    expect(login.hasOwnProperty('username')).toBeTruthy();
    expect(login.hasOwnProperty('password')).toBeTruthy();
  });


  it('deve aceitar valores iniciais para "username" e "password"', () => {
    const login = new Login();
    login.username = 'testuser';
    login.password = 'testpassword';

    expect(login.username).toEqual('testuser');
    expect(login.password).toEqual('testpassword');
  });
});
