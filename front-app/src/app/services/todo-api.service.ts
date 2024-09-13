import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from '../model/todo';




@Injectable({
  providedIn: 'root'
})
export class TodoApiService {

  private apiUrl = 'http://localhost:8080/api/todos';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.apiUrl);
  }


  update(todo:Todo): Observable<Todo> {
    return this.http.put<Todo>(this.apiUrl, todo);
  }

  delete(todo:Todo): Observable<Todo> {
    return this.http.request<Todo>('delete',this.apiUrl, {body:todo});
  }

  create(todo:Todo): Observable<Todo> {
    return this.http.post<Todo>(this.apiUrl, todo);
  }
}
