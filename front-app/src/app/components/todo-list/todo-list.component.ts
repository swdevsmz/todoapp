import { ChangeDetectionStrategy, Component , ChangeDetectorRef} from '@angular/core';
import { TodoApiService } from '../../services/todo-api.service';
import { CommonModule } from '@angular/common';
import { FormsModule, FormBuilder,FormGroup ,ReactiveFormsModule  } from '@angular/forms';
import { Todo } from '../../model/todo';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [
    CommonModule,
  ],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss',
  changeDetection: ChangeDetectionStrategy.Default,
})
export class TodoListComponent {
  todos: Todo[] = [];
  constructor(
    private todoApiService: TodoApiService,
    private changeDetector: ChangeDetectorRef
  ) {
  }

  ngOnInit(): void {
    this.findAll();
  }


  findAll(): void {
    this.todoApiService.findAll().subscribe((data) => {
      this.todos = data;
      this.changeDetector.detectChanges(); // 変更検出をトリガー
    });
  }

  update(todo: Todo, checked: boolean): void {
    todo.done = checked;
    this.todoApiService.update(todo).subscribe((data) => {
      console.log(data);
      this.findAll();
    });
  }

  delete(todo: Todo): void {
    this.todoApiService.delete(todo).subscribe((data) => {
      console.log(data);
      this.findAll();
    });
  }

  create(summary: string): void {
    const todo: Todo = { id: 0, summary: summary, done: false };
    this.todoApiService.create(todo).subscribe((data) => {
      console.log(data);
      this.findAll();
    });
  }
}
