import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpclientService {

  //private MARKET_GREETING_URI = "http://35.192.96.96:9003/market/hello";
  //private INTEGRATION_GREETING_URI = "http://35.193.73.9:9002/integration/hello";

  private MARKET_GREETING_URI = "http://34.67.201.241:9005/market/hello";
  private INTEGRATION_GREETING_URI = "http://34.67.201.241:9005/integration/hello";

  constructor(private httpClient: HttpClient) { }

  public getMarketGreeting(){
    return this.httpClient.get(this.MARKET_GREETING_URI);
  }

  public getIntegrationGreeting(){
    return this.httpClient.get(this.INTEGRATION_GREETING_URI);
  }

}