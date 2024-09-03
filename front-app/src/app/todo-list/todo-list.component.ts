import { Component } from '@angular/core';
import { ApiService, Todo } from '../services/api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss'
})
export class TodoListComponent {
  todos: Todo[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getTodos().subscribe(data => {
      this.todos = data;
      console.log(this.todos);
    });
  }

}
