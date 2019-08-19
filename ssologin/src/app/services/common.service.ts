import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  public config: any = {
    domain: 'http://jd.itying.com/'
  }

  constructor(public httpclient: HttpClient) { }

  ajaxPost(url: string, json: object) {
    var api = this.config.domain + url;

    return new Promise((resove, reject) => {
      this.httpclient.post(api, json).subscribe((response) => {
        resove(response);
      }, (err) => {
        reject(err);
      });
    });
  }

  ajaxGet(url: any) {
    return new Promise((resove, reject) => {
      this.httpclient.get(url).subscribe((response) => {
        resove(response);
      }, (err) => {
        reject(err);
      });
    });
  }

  ajaxPostSSO(url: any, json: object) {

    return new Promise((resove, reject) => {
      this.httpclient.post(url, json).subscribe((response) => {
        resove(response);
      }, (err) => {
        reject(err);
      });
    });
  }
}
