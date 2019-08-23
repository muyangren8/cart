import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { StorageService } from "../services/storage.service";
import { NavController } from "@ionic/angular";

@Component({
  selector: 'app-code',
  templateUrl: './code.page.html',
  styleUrls: ['./code.page.scss'],
})
export class CodePage implements OnInit {

  public cid: any = '';
  public phone: any = '';
  public code: any = '';
  public sendCodeBtn: any = false;
  public num: any = 30;


  constructor(public http: HttpService, public storage: StorageService, public nav: NavController) {
    this.cid = this.storage.get('cid');
    this.phone = this.storage.get('phone');
  }

  ngOnInit() {
    this.doTimer();
  }

  back() {
    this.nav.navigateBack('/tabs/tab2');
  }

  doRegister3() {
    this.http.ajaxGet('/sso/checkCode?phone=' + this.phone + '&code=' + this.code).then((response: any) => {
      console.log(response);
      if (response.code == 1) {
        //保存验证码
        this.nav.navigateForward('/sign-page');
      } else {
        alert('验证码验证失败，请重新验证');
      }
    });
  }

  //倒计时
  doTimer() {
    var timer = setInterval(() => {
      this.num--;
      if (this.num == 0) {
        this.sendCodeBtn = true;
        clearInterval(timer);
      }
    }, 1000);
  }

  //重新发送验证码
  sendCode() {
    this.http.ajaxGet("/sso/getCode?cid=" + this.cid).then((response: any) => {
      console.log(response);
      if (response.code == 1) {
        alert('发送验证码成功');
        this.num = 30;
        this.sendCodeBtn = false;
        this.doTimer();
      } else {
        alert(response.message);
      }

    });
  }
}
