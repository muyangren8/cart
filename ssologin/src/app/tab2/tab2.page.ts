import { Component } from '@angular/core';
import { CommonService } from "../services/common.service";
import { NavController } from '@ionic/angular';
import { StorageService } from "../services/storage.service";
import { EventService } from "../services/event.service";


@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {

  public manager: any = {
    username: '',
    password: ''
  }

  constructor(public common: CommonService, public nav: NavController, public storage: StorageService, public event: EventService) { }

  doLogin() {
    var api = '/sso/login';
    this.common.ajaxPostSSO(api, this.manager).then((response: any) => {
      console.log(response);
      if (response.code == 1) {
        alert("登录成功，跳转到回调地址");
        //this.storage.set('token', response.data);
        localStorage.setItem('token', response.data);

        window.location.href = localStorage.getItem('redirect') + "?token=" + localStorage.getItem('token');
        console.log(localStorage.getItem('redirect'));
      } else {
        alert("账号密码错误");
      }
    })
  }

  back(){
    window.location.href = localStorage.getItem('redirect');
  }
}
