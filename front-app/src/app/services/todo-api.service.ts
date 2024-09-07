import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Todo{
  id:number;
  summary:string;
  done:boolean;
}


@Injectable({
  providedIn: 'root'
})
export class TodoApiService {

  private apiUrl = 'http://localhost:8080/api/todos';

  constructor(private http: HttpClient) { }

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.apiUrl);
  }
}
