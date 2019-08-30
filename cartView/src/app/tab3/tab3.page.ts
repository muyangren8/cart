import { Component } from '@angular/core';
import { HttpService } from "../services/http.service";
import { ModalController, NavController } from '@ionic/angular';
import { StorageService } from "../services/storage.service";


@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page {
  public username: any = '';

  constructor(public http: HttpService, public modalController: ModalController, public nav: NavController, public storage: StorageService) {

  }

  ionViewWillEnter() {
    this.username = this.storage.get('username');
  }

  

  //跳转到登陆界面
  goToLogin() {
    this.nav.navigateForward('/login');
  }

  //注销登陆
  loginOut() {
    var api = '/market/sso/inValid?token=' + localStorage.getItem('token');
    this.http.ajaxGet(api).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        alert('注销成功');
        this.username = '';
        localStorage.clear();
      } else {
        alert('注销失败');
      }
    })
  }
}
