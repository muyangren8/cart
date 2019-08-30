import { Component, OnInit } from '@angular/core';
import { HttpService } from "../services/http.service";
import { StorageService } from "../services/storage.service";
import { NavController } from "@ionic/angular";

@Component({
  selector: 'app-sign-page',
  templateUrl: './sign-page.page.html',
  styleUrls: ['./sign-page.page.scss'],
})

export class SignPagePage implements OnInit {
  private token: any = '';
  private gname: any = '';
  private cname: any = '';
  private gid: any = '';
  private cid: any = '';
  private mid: any = '';
  private sign: any = {
    mid: '',
    gid: '',
    gname: '',
    cid: '',
    cname: '',
    aPlanNum: '',
    bPlanNum: '',
    cPlanNum: '',
    planStartDate: '',
    planEndDate: '',
    signDateA: '',
    signDateB: '',
    signatureImageA: '',
    signatureImageB: 'data:image/gif;base64,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',
  }

  constructor(public http: HttpService, public storage: StorageService,
    public nav: NavController) {
    this.token = localStorage.getItem('token');

    this.sign.signDateA = new Date().toISOString();
    this.sign.signDateB = new Date().toISOString();
    //this.sign.signatureImage = this.storage.get('signatureImage');
  }

  ionViewWillEnter() {
    console.log('进入了');
    this.gid = this.storage.get("gid");
    this.cid = this.storage.get("cid");
    this.mid = this.storage.get("mid");
    this.sign.signatureImageA = this.storage.get('signatureImageA');
    this.initName();
    //console.log(this.sign.signatureImageA);
  }

  ngOnInit() {

  }

  initName() {
    this.http.ajaxGet("/market/company/getCompanyById?id=" + this.gid + "&token=" + this.token).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.gname = response.data.gname;
      } else if (response.status == -1) {
        alert(response.msg);
        this.goToLogin();
      }
      else {
        alert(response.msg);
      }
    });
    this.http.ajaxGet("/market/cust/getCustById?id=" + this.cid + "&token=" + this.token).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.cname = response.data.cname;
      } else if (response.status == -1) {
        alert(response.msg);
        this.goToLogin();
      }
      else {
        alert(response.msg);
      }
    });
  }

  back() {
    this.nav.navigateBack('/tabs/tab2');
  }

  toSignA() {
    this.nav.navigateForward('/sign-pad');
    this.storage.set('signImageFlag', 'signatureImageA');
  }

  /*  toSignB() {
     this.nav.navigateForward('/sign-pad');
     this.storage.set('signImageFlag', 'signatureImageB');
   } */

  doSign() {
    this.checkLogin();

    //补充字段
    this.sign.cid = this.cid;
    this.sign.cname = this.cname;
    this.sign.gid = this.gid;
    this.sign.gname = this.gname;
    this.sign.mid = this.mid;
    console.log(this.sign);

    this.http.ajaxPost('/market/sign/doSign', this.sign).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        alert('协议签订成功');
        this.nav.navigateRoot('/tabs/tab2');
      } else if (response.status == -1) {
        alert(response.msg);
        this.goToLogin();
      }
      else {
        alert('协议签订失败');
      }
    });

    //清除localStorage
    this.storage.remove('signImageFlag');
    this.storage.remove('signatureImageA');
    //this.storage.remove('signatureImageB');
  }

  checkLogin() {
    this.http.ajaxGet('/market/sso/checkJwt?token=' + this.token).then((response: any) => {
      console.log(response);
      if (response.data == 200) {
        console.log('token有效');
      } else {
        this.goToLogin();
      }
    });
  }

  goToLogin() {
    //localStorage.setItem('redirect', location.href);
    //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
    this.nav.navigateForward('/login')
  }
}
