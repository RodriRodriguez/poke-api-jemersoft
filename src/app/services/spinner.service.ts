import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpinnerService {
  private showSpinnerSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  public showSpinner$ = this.showSpinnerSubject.asObservable();

  show(): void {
    this.showSpinnerSubject.next(true);
  }

  hide(): void {
    this.showSpinnerSubject.next(false);
  }
}
