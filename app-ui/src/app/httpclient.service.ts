import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  private MARKET_GREETING_URI = "http://35.193.233.108:9005/market/hello";
  private INTEGRATION_GREETING_URI = "http://35.193.233.108:9005/integration/hello";

  constructor(private httpClient: HttpClient) { }

  public getMarketGreeting(){
    var reqHeader = new HttpHeaders({ 
      'Authorization': 'Bearer ' + localStorage.getItem('ang-token')
    });
    //reqHeader.append('Authorization', 'Bearer ' + localStorage.getItem('ang-token'));
    return this.httpClient.get(this.MARKET_GREETING_URI, { headers: reqHeader });
  }

  public getIntegrationGreeting(){
    var reqHeader = new HttpHeaders({ 
      'Authorization': 'Bearer ' + localStorage.getItem('ang-token')
    });
    return this.httpClient.get(this.INTEGRATION_GREETING_URI, { headers: reqHeader });
  }

}