import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HeaderComponent } from './COMPONENTS/layout/header/header.component';
import { FooterComponent } from './COMPONENTS/layout/footer/footer.component';
import { IndexComponent } from './COMPONENTS/layout/index/index.component';
import { SignUpComponent } from './COMPONENTS/system/sign-up/sign-up.component';
import { SignInComponent } from './COMPONENTS/system/sign-in/sign-in.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AdmIndexComponent } from './COMPONENTS/layout/adm-index/adm-index.component';
import { AdmHeaderComponent } from './COMPONENTS/layout/adm-header/adm-header.component';
import { AdmFooterComponent } from './COMPONENTS/layout/adm-footer/adm-footer.component';
import { AtributoDateilsComponent } from './COMPONENTS/functions/atributo/atributo-dateils/atributo-dateils.component';
import { EnderecoDetailsComponent } from './COMPONENTS/functions/endereco/endereco-details/endereco-details.component';
import { ItemDetailsComponent } from './COMPONENTS/functions/item/item-details/item-details.component';
import { EnderecoListComponent } from './COMPONENTS/functions/endereco/endereco-list/endereco-list.component';
import { SaborDetailsComponent } from './COMPONENTS/functions/sabor/sabor-details/sabor-details.component';
import { SaborListComponent } from './COMPONENTS/functions/sabor/sabor-list/sabor-list.component';
import { PedidoDetailsComponent } from './COMPONENTS/functions/pedido/pedido-details/pedido-details.component';
import { PedidoListComponent } from './COMPONENTS/functions/pedido/pedido-list/pedido-list.component';
import { ProdutoDetailsComponent } from './COMPONENTS/functions/produto/produto-details/produto-details.component';
import { ProdutoListComponent } from './COMPONENTS/functions/produto/produto-list/produto-list.component';
import { ClienteDetailsComponent } from './COMPONENTS/functions/cliente/cliente-details/cliente-details.component';
import { ClienteListComponent } from './COMPONENTS/functions/cliente/cliente-list/cliente-list.component';
import { AtributoListComponent } from './COMPONENTS/functions/atributo/atributo-list/atributo-list.component';
import { ClienteDateilsInterfaceComponent } from './COMPONENTS/funtions-client/Cliente/cliente-dateils-interface/cliente-dateils-interface.component';
import { CarrinhoDatailsComponent } from './COMPONENTS/funtions-client/Carrinho/carrinho-datails/carrinho-datails.component';
import { ProfileComponent } from './COMPONENTS/funtions-client/Cliente/profile/profile.component';
import { ProdutoListInterfaceComponent } from './COMPONENTS/funtions-client/Produto/produto-list-interface/produto-list-interface.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    IndexComponent,
    SignUpComponent,
    SignInComponent,
    AdmIndexComponent,
    AdmHeaderComponent,
    AdmFooterComponent,
    AtributoDateilsComponent,
    AtributoListComponent,
    EnderecoDetailsComponent,
    ItemDetailsComponent,
    EnderecoListComponent,
    SaborDetailsComponent,
    SaborListComponent,
    PedidoDetailsComponent,
    PedidoListComponent,
    ProdutoDetailsComponent,
    ProdutoListComponent,
    ClienteDetailsComponent,
    ClienteListComponent,
    ClienteDateilsInterfaceComponent,
    CarrinhoDatailsComponent,
    ProfileComponent,
    ProdutoListInterfaceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
