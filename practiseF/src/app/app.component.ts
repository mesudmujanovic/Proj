import { Component } from '@angular/core';
import { UserService } from './service/user.service';
import { User } from './constant/user';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  user: User = { name: '', lastName: '' };
  savedUser: User | null = null;

  constructor(private userService: UserService) { }

  saveUser() {
    this.userService.createUser(this.user).subscribe({
      next: (response) => {
        this.savedUser = response;
        this.user = { name: '', lastName: '' };
      },
      error: (err) => console.error('Greška:', err)
    });
  }
}
