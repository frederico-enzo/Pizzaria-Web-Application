import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './COMPONENTS/system/sign-up/sign-up.component';
import { SignInComponent } from './COMPONENTS/system/sign-in/sign-in.component';
import { AdmIndexComponent } from './COMPONENTS/layout/adm-index/adm-index.component';
import { SaborListComponent } from './COMPONENTS/functions/sabor/sabor-list/sabor-list.component';
import { ProdutoListComponent } from './COMPONENTS/functions/produto/produto-list/produto-list.component';
import { PedidoListComponent } from './COMPONENTS/functions/pedido/pedido-list/pedido-list.component';
import { EnderecoListComponent } from './COMPONENTS/functions/endereco/endereco-list/endereco-list.component';
import { ClienteListComponent } from './COMPONENTS/functions/cliente/cliente-list/cliente-list.component';
import { AtributoListComponent } from './COMPONENTS/functions/atributo/atributo-list/atributo-list.component';
import { rotaGuardGuard } from './GUARDS/rota-guard.guard';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
  {path: "login",component: SignInComponent},
  { path: "signup", component: SignUpComponent },
  { path: "admin", component: AdmIndexComponent, canActivate: [rotaGuardGuard], children: [
    {path : "atributo-adm" , component: AtributoListComponent},
    {path : "cliente-adm" , component: ClienteListComponent},
    {path : "endereco-adm" , component: EnderecoListComponent},
    {path : "pedido-adm" , component: PedidoListComponent},
    {path : "produto-adm" , component: ProdutoListComponent},
    {path : "sabor-adm" , component: SaborListComponent},
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
