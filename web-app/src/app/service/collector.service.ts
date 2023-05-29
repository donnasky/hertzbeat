import {HttpClient, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

import {Message} from '../pojo/Message';
import {Page} from '../pojo/Page';
import {Collector} from '../pojo/Collector';

const collector_uri = '/collector';

@Injectable({
  providedIn: 'root'
})
export class CollectorService {
  constructor(private http: HttpClient) {}

  public loadCollectors(
    search: string | undefined,
    pageIndex: number,
    pageSize: number): Observable<Message<Page<Collector>>> {
    pageIndex = pageIndex ? pageIndex : 0;
    pageSize = pageSize ? pageSize : 8;
    // 注意HttpParams是不可变对象 需要保存set后返回的对象为最新对象
    let httpParams = new HttpParams();
    httpParams = httpParams.appendAll({
      pageIndex: pageIndex,
      pageSize: pageSize
    });
    if (search != undefined && search != '' && search.trim() != '') {
      httpParams = httpParams.append('search', search.trim());
    }
    const options = { params: httpParams };
    return this.http.get<Message<Page<Collector>>>(collector_uri, options);
  }

  public newCollectors(body: Collector[]): Observable<Message<any>> {
    return this.http.post<Message<any>>(collector_uri, body);
  }

  public newCollector(body: Collector): Observable<Message<any>> {
    const collectors = [];
    collectors.push(body);
    return this.http.post<Message<any>>(collector_uri, collectors);
  }

  public editCollector(body: Collector): Observable<Message<any>> {
    return this.http.put<Message<any>>(collector_uri, body);
  }

  public deleteCollectors(collectorIds: Set<number>): Observable<Message<any>> {
    let httpParams = new HttpParams();
    collectorIds.forEach(collectorId => {
      // 注意HttpParams是不可变对象 需要保存append后返回的对象为最新对象
      // append方法可以叠加同一key, set方法会把key之前的值覆盖只留一个key-value
      httpParams = httpParams.append('ids', collectorId);
    });
    const options = { params: httpParams };
    return this.http.delete<Message<any>>(collector_uri, options);
  }
}
