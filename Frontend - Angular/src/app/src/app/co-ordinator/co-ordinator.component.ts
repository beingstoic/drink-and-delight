import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-co-ordinator',
  templateUrl: './co-ordinator.component.html',
  styleUrls: ['./co-ordinator.component.css']
})
export class CoOrdinatorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  logout() {
    window.location.reload();
  }

}
