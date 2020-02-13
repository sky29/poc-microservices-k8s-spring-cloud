import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  //private MARKET_GREETING_URI = "http://35.192.96.96:9003/market/hello";
  //private INTEGRATION_GREETING_URI = "http://35.193.73.9:9002/integration/hello";

  private MARKET_GREETING_URI = "http://34.67.112.70:9005/market/hello";
  private INTEGRATION_GREETING_URI = "http://34.67.112.70:9005/integration/hello";

  constructor(private httpClient: HttpClient) { }

  public getMarketGreeting(){
    //alert (localStorage.getItem('ang-token'));
    var reqHeader = new HttpHeaders({ 
      //'Authorization': 'Bearer ' + localStorage.getItem('ang-token')
    });
    reqHeader.append('Authorization', 'Bearer ' + localStorage.getItem('ang-token'));
    return this.httpClient.get(this.MARKET_GREETING_URI, { headers: reqHeader });
  }

  public getIntegrationGreeting(){
    var reqHeader = new HttpHeaders({ 
      'Authorization': 'Bearer ' + localStorage.getItem('ang-token')
    });
    return this.httpClient.get(this.INTEGRATION_GREETING_URI, { headers: reqHeader });
  }

}