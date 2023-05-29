import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResultComponent } from './components/result/result.component';
import { StartComponent } from './components/start/start.component';

const routes: Routes = [
  { path: 'search', component: StartComponent },
  { path: 'result/:id', component: ResultComponent }, // Agrega el parámetro ':id' en la ruta
  { path: '', pathMatch: 'full', redirectTo: 'search' },
  { path: '**', pathMatch: 'full', redirectTo: 'search' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
