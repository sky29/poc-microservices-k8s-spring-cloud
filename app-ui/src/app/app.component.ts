import { Component } from '@angular/core';
import { HttpclientService } from './httpclient.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-ui';
  message = 'hello (default)';

  constructor(private httpclientService: HttpclientService) { }


  public greetingMarket(){
    this.httpclientService.getMarketGreeting().subscribe((data: any[])=>{
      this.message = JSON.stringify(data);
    }) 
  }

  public greetingIntegration(){
    this.httpclientService.getIntegrationGreeting().subscribe((data: any[])=>{      
      this.message = JSON.stringify(data);
    })
  }
}
