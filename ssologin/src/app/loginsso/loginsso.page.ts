import { Component, OnInit } from '@angular/core';
import { CommonService } from "../services/common.service";
import { NavController } from '@ionic/angular';
import { StorageService } from "../services/storage.service";
import { EventService } from "../services/event.service";



@Component({
  selector: 'app-loginsso',
  templateUrl: './loginsso.page.html',
  styleUrls: ['./loginsso.page.scss'],
})
export class LoginssoPage implements OnInit {

  public user: any = {
    name: '',
    password: ''
  }

  constructor(public common: CommonService, public nav: NavController, public storage: StorageService, public event: EventService) { }

  ngOnInit() {
  }

  doLogin() {
    var api = '/sso/login';
    this.common.ajaxPostSSO(api, this.user).then((response: any) => {
      console.log(response);
      if (response.code == 1) {
        alert("登录成功，跳转到回调地址");
        //this.storage.set('token', response.data);
        localStorage.setItem('token',response.data);

        this.nav.navigateRoot("/tabs/tab1");
        this.event.eventEmit.emit('token');
      } else {
        alert("账号密码错误");
      }
    })
  }
}
