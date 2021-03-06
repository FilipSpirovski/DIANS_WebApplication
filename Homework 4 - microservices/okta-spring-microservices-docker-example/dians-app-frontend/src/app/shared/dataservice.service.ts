import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Disease, Pharmacy } from './appmodels.model'

@Injectable()
export class DataService {
  url = "http://localhost:9091" //"http://clinicpharmacyapi"
  url2 = "http://localhost:9092" //"http://forumapi"

  constructor(private http: HttpClient){}

  getClinics(type) {
    return this.http.get<Pharmacy[]>(this.url + "/api/clinics/type/" + type);
  }

  getPharmacies() {
    return this.http.get<Pharmacy[]>(this.url + "/api/pharmacies/all");
  }

  getSingleClinic(id){
    return this.http.get<Pharmacy>(this.url + "/api/clinics/" + id);
  }

  getSinglePharmacy(id) {
    return this.http.get<Pharmacy>(this.url + "/api/pharmacies/" + id)
  }

  getDiseases() {
    return this.http.get<Disease[]>(this.url2 + "/api/diseases/all");
  }
  getDiseasesByType(type) {
    return this.http.get<Disease[]>(this.url2 + "/api/diseases/type/" + type);
  }

  getSingleDisease(id) {
    return this.http.get<Disease>(this.url2 + "/api/diseases/" + id);
  }

  saveComment(commentDTO) {
    let options = { headers: new HttpHeaders({'Content-Type': 'application/json; charset=UTF-8'})}

    this.http.post(this.url2 + "/api/comments/add" , commentDTO, options).subscribe();
  }
}


