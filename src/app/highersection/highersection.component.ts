import { Component, OnInit } from '@angular/core';
import { VideosserviceService } from "../videosservice.service";
@Component({
  selector: 'app-highersection',
  templateUrl: './highersection.component.html',
  styleUrls: ['./highersection.component.css']
})
export class HighersectionComponent implements OnInit {

  constructor(private service:VideosserviceService) {
  }

  ngOnInit(): void {
  }
  chemistryB : boolean = false;
  chemistry = [];
  mathsB : boolean = false;
  maths = [];
  physicsB : boolean=false;
  physics= [];
  puzzlesB : boolean=false;
  puzzles = [];
  physics12:string = 'p';
  chemistry12:string = 'c';
  maths12:string = 'm';
  puzzles12:string = 'pz';
    public chemistry1(){
      this.chemistryB = true;
      this.mathsB = false;
      this.physicsB = false;
      this.puzzlesB = false;
    this.service.getlinks(this.chemistry12).subscribe((resp)=>{
      console.log(resp);
      if(this.chemistry.length !== 9){
        this.chemistry.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
        console.log(this.chemistry);
      }
   });
  }
  public maths1(){
    this.chemistryB = false;
    this.mathsB = true;
    this.physicsB = false;
    this.puzzlesB = false;
    this.service.getlinks(this.maths12).subscribe((resp)=>{
      if(this.maths.length !== 9){
        this.maths.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
        console.log(this.maths);
      }
   });
  }
  public physics1(){
    this.chemistryB = false;
    this.mathsB = false;
    this.physicsB = true;
    this.puzzlesB = false;
    this.service.getlinks(this.puzzles12).subscribe((resp)=>{
      console.log(resp);

      if(this.physics.length !== 9){
        this.physics.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
        console.log(this.physics);
        console.log(resp)
      }
   });
  }

  public puzzles1(){
    this.puzzlesB = true;
    this.chemistryB = false;
    this.physicsB = false;
    this.mathsB = false;
    this.service.getlinks(this.puzzles12).subscribe((resp) =>{
      if(this.puzzles.length !== 9){
        this.puzzles.push(resp["video1"],resp["video2"],resp["video3"],resp["video4"],resp["video5"],resp["video6"],resp["video7"],resp["video8"],resp["video9"]);
      }
    });
  }

}
