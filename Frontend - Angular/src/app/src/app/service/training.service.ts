import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable} from 'rxjs';
import { Training } from '../model/training';
import { Course } from '../model/course';

const AUTH_API = 'http://localhost:8080/training';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient) { }

  addTraining(training : Training):Observable<any> {
    return this.http.post(AUTH_API,{
      trainingName : training.trainingName,
      startDate : training.startDate,
      endDate : training.endDate,
      facultyId : training.faculty.id,
      courseId : training.course.id
    },httpOptions);
 }

 updateTraining(training : Training):Observable<any> {
  return this.http.put(AUTH_API + `/${training.id}`, {
    trainingName : training.trainingName,
    startDate : training.startDate,
    endDate : training.endDate,
    facultyId : training.faculty.id
  },httpOptions);
}

 deleteTraining(trainingId):Observable<any> {
  return this.http.delete(AUTH_API + `/${trainingId}`, { responseType: 'json' });
}

getTraining(trainingId):Observable<any> {
  return this.http.get(AUTH_API + `/${trainingId}`, { responseType: 'json' });
}

getTrainings(): Observable<any> {
  return this.http.get(AUTH_API, { responseType: 'json' })
}

getCourses(): Observable<Course[]> {
 return this.http.get<Course[]>(AUTH_API + '/courses', { responseType: 'json' })
}

getFaculties(): Observable<any> {
  return this.http.get(AUTH_API + '/faculties', { responseType: 'json' })
}

}