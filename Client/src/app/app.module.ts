import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './system/login/login.component';
import { HeaderComponent } from './COMPONENTS/layout/header/header.component';
import { FooterComponent } from './COMPONENTS/layout/footer/footer.component';
import { IndexComponent } from './COMPONENTS/layout/index/index.component';
import { SignUpComponent } from './COMPONENTS/system/sign-up/sign-up.component';
import { SignInComponent } from './COMPONENTS/system/sign-in/sign-in.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    IndexComponent,
    SignUpComponent,
    SignInComponent
  ],
  imports: [
    BrowserModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
