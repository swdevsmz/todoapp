import { ChangeDetectionStrategy, Component } from '@angular/core';
import { TodoApiService, Todo } from '../../services/todo-api.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule, MatCheckboxModule, FormsModule],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss',
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TodoListComponent {
  todos: Todo[] = [];

  constructor(private todoApiService: TodoApiService) {}

  ngOnInit(): void {
    this.todoApiService.getTodos().subscribe((data) => {
      this.todos = data;
      console.log(this.todos);
    });
  }
}
