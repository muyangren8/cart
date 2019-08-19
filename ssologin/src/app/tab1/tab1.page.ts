import { Component, OnInit } from '@angular/core';
import { CommonService } from "../services/common.service";
import { NavController } from '@ionic/angular';
import { StorageService } from "../services/storage.service";
import { EventService } from "../services/event.service";



@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
})
export class Tab1Page implements OnInit {

  public redirect: any = '';
  public token: any = '';

  

  constructor(public common: CommonService, public nav: NavController, public storage: StorageService, public event: EventService) { }

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
      this.common.ajaxGet(api).then((responese: any) => {
        console.log(responese);
        if (responese.data) {
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
