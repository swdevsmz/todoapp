import { ChangeDetectionStrategy, Component , ChangeDetectorRef} from '@angular/core';
import { TodoApiService, Todo } from '../../services/todo-api.service';
import { CommonModule } from '@angular/common';
import { FormsModule, FormBuilder,FormGroup ,ReactiveFormsModule  } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [
    CommonModule,
    MatCheckboxModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TodoListComponent {
  todos: Todo[] = [];
  todoForm: FormGroup;
  constructor(
    private todoApiService: TodoApiService,
    private formBuilder: FormBuilder,
    private changeDetector: ChangeDetectorRef
  ) {
    this.todoForm = this.formBuilder.group({
      summary: ''
    });
  }

  ngOnInit(): void {
    this.findAll();
  }

  onSubmit(): void {
    this.create(this.todoForm.value.summary);
  }

  findAll(): void {
    this.todoApiService.getTodos().subscribe((data) => {
      this.todos = data;
      console.log(this.todos);
    });
    this.changeDetector.detectChanges();
  }

  update(todo: Todo, checked: boolean): void {
    todo.done = checked;
    this.todoApiService.update(todo).subscribe((data) => {
      console.log(data);
    });
    this.findAll();
  }

  delete(todo: Todo): void {
    this.todoApiService.delete(todo).subscribe((data) => {
      console.log(data);
    });
    this.findAll();
  }

  create(summary: string): void {
    const todo: Todo = { id: 0, summary: summary, done: false };
    this.todoApiService.create(todo).subscribe((data) => {
      console.log(data);
    });
    this.findAll();
  }
}
