import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { throwError } from 'rxjs';

import 'rxjs/add/operator/catch';

import { environment } from '../environments/environment';
import { HttpHeaders, HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';

import { catchError, map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
    'Access-Control-Allow-Headers': 'X-Requested-With, Origin, Content-Type, X-Auth-Token',
    'Access-Control-Max-Age': '1728000',
    //'Connection': 'Keep-Alive',
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})

@Injectable()
export class RestService {

  constructor(
        private http: HttpClient
    ) {}

    private formatErrors(error: any) {
      return  throwError(error.error);
    }

    private extractData(res: Response) {
        let body = res;
        console.log("REST REQUEST BODY: ");
        console.log(body);
        return body || { };
    }

    private handleError(error: HttpErrorResponse) {
            if (error.error instanceof ErrorEvent) {
                // A client-side or network error occurred. Handle it accordingly.
                console.error('An error occurred:', error.error.message);
            } else {
                // The backend returned an unsuccessful response code.
                // The response body may contain clues as to what went wrong,
                console.error(
                    `Backend returned code ${error.status},` +
                    `body was: ${error.error}`);
            }
            // return an observable with a user-facing error message
            return throwError('Something bad happened; please try again later.');
        }

    /* GET */
    get(path: string, params: HttpParams = new HttpParams()): Observable<any> {
      return this.http.get(`${environment.api_url}${path}`, { params })
                      .pipe(map(this.extractData), catchError(this.handleError));
    }

    /* PUT */
    put(path: string, body: Object = {}): Observable<any> {
      return this.http.put(`${environment.api_url}${path}`, JSON.stringify(body))
                      .pipe(catchError(this.formatErrors));
    }

    /* POST */
    post(path: string, body: Object = {}): Observable<any> {
        console.log("body: " + body);
        console.log(`${environment.api_url}${path}`);
        path = `${environment.api_url}${path}`;
      return this.http.post<any>(path, JSON.stringify(body), httpOptions).pipe(catchError(this.handleError));
    }

    /* DELETE */
    delete(path): Observable<any> {
      return this.http.delete(`${environment.api_url}${path}`)
                      .pipe(catchError(this.formatErrors));
    }
  }
