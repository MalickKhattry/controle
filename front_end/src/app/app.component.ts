import {Component, OnInit} from '@angular/core';
import {SecurityService} from "./sevices/SecurityService";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(public securityservice:SecurityService) {

  }

  title = 'front_end';
  SecurityService: any;
  loginTemplate: any;
public async ngOnInit(){

}


  async login() {
    await this.securityservice.kcService.login(
      {redirectUri: window.location.origin}
    )
  }

  onLogout() {
    this.securityservice.kcService.logout(window.location.origin);
  }
}
