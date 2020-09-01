import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class VideosserviceService {

  constructor(private http:HttpClient) { }

//   public getlinks(name:string):any{
//     return this.http.get(name,{responseType: 'json'});
// }

  public getlinks(name:string):any{
    switch (name) {
      case "p":
        return this.http.get("http://localhost:8080/videos/physics12",{responseType :  'json'});
          break;
      case "c":
        return this.http.get("http://localhost:8080/videos/chemistry12",{responseType: 'json'});
      case "m":
        return this.http.get("http://localhost:8080/videos/maths12",{responseType: 'json'});
          break;
      case "pz":
        return this.http.get("http://localhost:8080/videos/puzzles12",{responseType: 'json'});
          break;
      case "s":
        return this.http.get("http://localhost:8080/videos/stories12",{responseType:  'json'});
          break;
      case "k":
        return this.http.get("http://localhost:8080/videos/kidsnumbers12",{responseType: 'json'});
          break;
      case "f":
        return this.http.get("http://localhost:8080/videos/fun12",{responseType: 'json'});
          break;
        case "r":
          return this.http.get("http://localhost:8080/videos/rhymes12",{responseType:'json'});
          break;
          default: { 
            console.log("Invalid choice"); 
            break;
          }
  }
}
}   
  //}
//}
