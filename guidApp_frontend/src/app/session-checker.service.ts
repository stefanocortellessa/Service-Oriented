import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { CanActivate, Router } from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class SessionCheckerService {

  constructor( private injector: Injector,
               private router: Router) { }

    intercept (req, next) {

        //let authService = this.injector.get(AuthService);
        let tokenizedReq = req.clone({
            setHeaders: {
                Authorization: `Token ${this.getToken()}`
            }
        });
        return next.handle(tokenizedReq);
    }

    getToken () {

        return localStorage.getItem('token');
    }

    loggedIn() {

        return !!localStorage.getItem('token');
    }

    canActivate(): boolean {

        if (this.loggedIn()) {

            return true;
        }
        else {

            this.router.navigate(['/login']);
            return false;
        }
    }
}
