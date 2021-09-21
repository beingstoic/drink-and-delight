import { Component, OnInit } from '@angular/core';
import {HttpService} from '../service/http.service'

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {

  bookList:any=[];
  searchTextId='';
  searchTextAuthor='';
  searchTextYear='';
  searchTextTitle='';
  i:boolean=false;
  a:boolean=false;
  y:boolean=false;
  t:boolean=false;

  constructor(private service:HttpService) { }

  ngOnInit(): void {
    this.service.getBookList().subscribe(data =>{
      console.log(data);
  
      this.bookList = data;
    })
  }

  
  /*onSearch(item){
    
    
    return (item.author.toLocaleLowerCase().indexOf(this.searchTextAuthor.toLocaleLowerCase())) != -1;
    
  }*/
  searchById(){
    if(this.searchTextId!=''){
      this.bookList=this.bookList.filter(res=>{
  
        return (res.id==this.searchTextId);
      });
     }
     else if(this.searchTextId==''){
       this.ngOnInit();
     }

  }

  searchByYear(){
    if(this.searchTextYear!=''){
      console.log(this.searchTextYear);
      this.bookList=this.bookList.filter(res=>{
  
        return ((res.year+"").toLocaleLowerCase().indexOf(this.searchTextYear.toLocaleLowerCase())) != -1;
      });
     }
     else if(this.searchTextYear==''){
       this.ngOnInit();
     }
    
  }
  searchByAuthor(){
   // return (item.author.toLocaleLowerCase().indexOf(this.searchTextAuthor.toLocaleLowerCase())) != -1;
   if(this.searchTextAuthor!=''){
    this.bookList=this.bookList.filter(res=>{

      return (res.author.toLocaleLowerCase().indexOf(this.searchTextAuthor.toLocaleLowerCase())) != -1;
    });
   }
   else if(this.searchTextAuthor==''){
     this.ngOnInit();
   }
   
    
  }
  searchByTitle(){
    if(this.searchTextTitle!=''){
      this.bookList=this.bookList.filter(res=>{
  
        return (res.title.toLocaleLowerCase().indexOf(this.searchTextTitle.toLocaleLowerCase())) != -1;
      });
     }
     else if(this.searchTextTitle==''){
       this.ngOnInit();
     }

  }

}
