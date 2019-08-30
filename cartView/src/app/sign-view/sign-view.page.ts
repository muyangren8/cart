import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NavController } from '@ionic/angular';
import { HttpService } from '../services/http.service';

@Component({
  selector: 'app-sign-view',
  templateUrl: './sign-view.page.html',
  styleUrls: ['./sign-view.page.scss'],
})
export class SignViewPage implements OnInit {

  private cid: any = '';
  private sign: any = '';

  constructor(private route: ActivatedRoute, public nav: NavController, public http: HttpService) {
    this.cid = this.route.snapshot.queryParams.cid;
    console.log(this.cid);
  }

  ngOnInit() {
  }

  back() {
    this.nav.navigateBack('/tabs/tab2');
  }

  ionViewWillEnter() {
    this.http.ajaxGet('/market/sign/getSignByCid?cid=' + this.cid+'&token='+localStorage.getItem('token')).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        this.sign = response.data;
      }  else if (response.status == -1) {
        alert(response.msg);
        //localStorage.setItem('redirect', location.href);
        //window.location.href = 'http://localhost:8200/tabs/tab1?order=checkLogin&redirect=' + window.location.origin + '/redirect';
        this.nav.navigateForward('/login')
      }
      else {
        alert('无法获取该客户的协议');
        this.back();
      }
    });
  }

}
