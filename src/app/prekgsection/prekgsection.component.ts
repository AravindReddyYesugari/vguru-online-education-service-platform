import { Component, OnInit } from '@angular/core';
import { VideosserviceService } from "../videosservice.service";


@Component({
  selector: 'app-prekgsection',
  templateUrl: './prekgsection.component.html',
  styleUrls: ['./prekgsection.component.css']
})


export class PrekgsectionComponent implements OnInit{
    constructor(private service: VideosserviceService) {
  }

  ngOnInit(): void {
  }
  alphabetsB: boolean = false;
  alphabets = [];
  numbersB: boolean = false;
  numbers = [];
  storiesB: boolean = false;
  stories = [];
  riddlesB: boolean = false;
  riddles = [];
  rhymes12: string ='r';
  fun12: string ='f';
  kidsnumbers12: string = 'k';
  storieskids12: string = 's';
  
    statement: boolean =  true;

    public stories1(){
    this.riddlesB = false;
    this.alphabetsB = false;
    this.numbersB = false;
    this.storiesB = true;
    this.statement = false;
    this.service.getlinks(this.storieskids12).subscribe((resp)=>{
      if(this.stories.length !== 9){
        this.stories.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
      }
   });

  }

    public numbers1(){
    this.riddlesB = false;
    this.alphabetsB = false;
    this.numbersB = true;
    this.storiesB = false;
    this.statement = false;
    this.service.getlinks(this.kidsnumbers12).subscribe((resp)=>{
      if(this.numbers.length !== 9){
        this.numbers.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
     
      }
   });
  }


    public riddles1(){
    this.riddlesB = true;
    this.alphabetsB = false;
    this.numbersB = false;
    this.storiesB = false;
    this.statement = false;
    this.service.getlinks(this.fun12).subscribe((resp)=>{
      if(this.riddles.length !== 9){
        console.log(resp);
        this.riddles.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
       
      }
   });

  }


      public alphabets1(){
      this.riddlesB = false;
      this.alphabetsB = true;
      this.numbersB = false;
      this.storiesB = false;
      this.statement = false;
    this.service.getlinks(this.rhymes12).subscribe((resp)=>{
      if(this.alphabets.length !== 9){
        this.alphabets.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
      }
   });
  }





}
