import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { NavController } from '@ionic/angular';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-logincheck',
  templateUrl: './logincheck.page.html',
  styleUrls: ['./logincheck.page.scss'],
})
export class LogincheckPage implements OnInit {

  public redirect: any = '';
  public token: any = '';

  constructor(public http: HttpService, public nav: NavController, public storage: StorageService) { }

  ngOnInit() {
    this.token = localStorage.getItem('token');
    this.redirect = this.getUrlParam('redirect');
    localStorage.setItem('redirect', this.redirect);
    var order = this.getUrlParam('order');
    switch (order) {
      case 'checkLogin':
        this.checkLogin();
        break;
      default:
        console.log('不支持的order' + order);
    }
  }

  checkLogin() {
    var token = localStorage.getItem('token');
    if (token == null || token.length == 0) {
      this.goLogin();
    } else {
      //有token检查token是否还有效
      var api = '/sso/checkJwt?token=' + token;
      this.http.ajaxGet(api).then((responese: any) => {
        console.log(responese);
        if (responese.status==200) {
          window.location.href = this.getUrlParam('redirect') + "?token=" + localStorage.getItem('token');
        } else {
          this.goLogin();
        }
      })
    }
  }

  goLogin() {
    this.nav.navigateForward('/tabs/tab2')
  }


  getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
  }


}
