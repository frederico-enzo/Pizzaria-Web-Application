import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
showProfileMenu = true; 
showPedidoMenu = true; 

  toggleProfileMenu() {
    this.showProfileMenu = !this.showProfileMenu;
  }

  togglePedidoMenu() {
    this.showPedidoMenu = !this.showPedidoMenu;
  }
  
}
