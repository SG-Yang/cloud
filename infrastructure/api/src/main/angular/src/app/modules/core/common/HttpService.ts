import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Http, RequestOptions, Response} from "@angular/http";
@Injectable()
export class HttpService<Q, T> {
  //private url = 'http://localhost:8090/';  // URL to web API
  private component: string;

  constructor(private http?: Http) {
  }

  setComponent(component: string): HttpService<Q, T> {
    this.component = component;
    return this;
  }

  getHttp(): Http {
    return this.http;
  }

  setHttp(http: Http): HttpService<Q, T> {
    this.http = http;
    return this;
  }

  getItems(pathUrl: string): Observable<T> {
    ;
    return this.http.get(this.component + "/" + pathUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  postItemsProvideComponent(domain: Q, component: string): Observable<T> {
    let dynamicComponent: string;
    if (component) {
      dynamicComponent = component;
    } else {
      dynamicComponent = this.component;
    }
    return this.http.post(dynamicComponent, domain)
      .map(this.extractData)
      .catch(this.handleError);
  }

  postItems(domain: Q): Observable<T> {
    return this.http.post(this.component, domain)
      .map(this.extractData)
      .catch(this.handleError);
  }

  login(domain: Q, options: RequestOptions): Observable<T> {
    return this.http.post(this.component, JSON.stringify(domain), options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  extractData(res: Response) {
    let body = res.json();
    console.log("response is:" + body);
    return body || {};
  }

  handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
