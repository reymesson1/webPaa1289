import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MisCursosComponent } from './mis-cursos/mis-cursos.component';
import { ProfileComponent } from './profile/profile.component';
import { AreapersonalComponent } from './areapersonal/areapersonal.component'; 
import { TaskComponent } from './task/task.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', children:[
      { path: '', pathMatch: 'full', redirectTo: 'login' },
      { path: '', component: AppComponent },
      { path: 'home', component: HomeComponent },
      { path: 'dashboard/:id', component: DashboardComponent },
      { path: 'task/:idcurso/:idmodulo/:idtask', component: TaskComponent },
      { path: 'miscursos', component: MisCursosComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'areapersonal', component: AreapersonalComponent },
      { path: 'login', component: LoginComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
