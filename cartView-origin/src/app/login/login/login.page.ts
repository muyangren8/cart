import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/services/http.service';
import { NavController } from '@ionic/angular';
import { StorageService } from 'src/app/services/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  ngOnInit(): void {
    
  }

  public manager: any = {
    username: '',
    password: ''
  }

  constructor(public http: HttpService, public nav: NavController, public storage: StorageService) { }

  doLogin() {
    var api = '/sso/login';
    this.http.ajaxPost(api, this.manager).then((response: any) => {
      console.log(response);
      if (response.status == 200) {
        alert("登录成功，跳转到回调地址");
        //this.storage.set('token', response.data);
        localStorage.setItem('token', response.data);

        //window.location.href = localStorage.getItem('redirect') + "?token=" + localStorage.getItem('token');
        this.nav.navigateRoot('/tabs/tab2')
        //console.log(localStorage.getItem('redirect'));
      } else {
        alert("账号密码错误");
      }
    })
  }

  back(){
    window.location.href = localStorage.getItem('redirect');
  }
}
