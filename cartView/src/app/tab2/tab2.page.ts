import { Component, ViewChild, ElementRef } from '@angular/core';
import { HttpService } from "../services/http.service";
import { StorageService } from "../services/storage.service";
import { NavController } from "@ionic/angular";


@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss']
})
export class Tab2Page {
  private token: any = '';
  private mid: any = '';
  private gid: any = '';
  private cid: any = '';
  private companys: any;
  private custs: any;

  @ViewChild("signBtn", { static: false }) signBtn;

  constructor(public http: HttpService, public storage: StorageService, public nav: NavController) {

  }



  ionViewWillEnter() {
    this.token = localStorage.getItem('token');
    if (this.token != null) {
      var info = this.token.split(".")[1];
      var username = JSON.parse(window.atob(info)).name;
      this.getManagerId(username);
    } else {
      //localStorage.setItem('redirect', location.href);
      //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
      this.nav.navigateForward('/login')
    }
  }



  getManagerId(username) {
    this.http.ajaxGet('/market/manager/getMidByUsername?username=' + username + '&token=' + this.token).then((response: any) => {
      console.log(response)
      if (response.status == 200) {
        this.mid = response.data;
        console.log(this.mid);
        this.initCompany(this.mid);
      } else if (response.status == -1) {
        alert(response.msg);
        //localStorage.setItem('redirect', location.href);
        //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
        this.nav.navigateForward('/login')
      } else {
        console.log(response.msg);
      }
    });
  }

  initCompany(mid) {
    this.http.ajaxGet("/market/company/getCompanyList?mid=" + mid + "&token=" + this.token).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.companys = response.data;
      } else if (response.status == -1) {
        alert(response.msg);
        //localStorage.setItem('redirect', location.href);
        //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
        this.nav.navigateForward('/login')
      }
      else {
        alert(response.msg);
      }
    });
  }

  initCust() {
    this.http.ajaxGet("/market/cust/getCustList?gid=" + this.gid + "&token=" + this.token).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.custs = response.data;
      }
      else if (response.status == -1) {
        alert(response.msg);
        //localStorage.setItem('redirect', location.href);
        //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
        this.nav.navigateForward('/login')
      }
      else {
        alert(response.msg);
      }
    });
  }

  hasCid() {
    if (this.cid != null) {
      this.signBtn.disabled = false;
    } else {
      this.signBtn.disabled = true;
    }
  }

  toSign(cid) {
    this.cid = cid;
    this.storage.set("gid", this.gid);
    this.storage.set("cid", cid);
    this.storage.set("mid", this.mid);

    this.http.ajaxGet("/market/sso/getCode?cid=" + cid).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.storage.set('phone', response.data);
        this.nav.navigateForward('/code');
      } else {
        alert('发送验证码失败' + response.msg);
      }
    });

    //this.nav.navigateForward("/sign-page");
  }

  toView(cid) {
    this.nav.navigateForward(['/sign-view'], {
      queryParams: {
        cid: cid
      }
    });
  }
}
