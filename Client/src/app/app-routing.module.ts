import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './COMPONENTS/layout/index/index.component';
import { SignUpComponent } from './COMPONENTS/system/sign-up/sign-up.component';
import { SignInComponent } from './COMPONENTS/system/sign-in/sign-in.component';
import { AdmIndexComponent } from './COMPONENTS/layout/adm-index/adm-index.component';

const routes: Routes = [
  { path: "", redirectTo: "login", pathMatch: "full" },
  {path: "login",component: SignInComponent},
  { path: "signup", component: SignUpComponent },
  { path: "admin", component: AdmIndexComponent, children: [] },
  { path: "client", component: IndexComponent, children: [] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
