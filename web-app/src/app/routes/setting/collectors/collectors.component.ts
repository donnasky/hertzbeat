import {Component, Inject, OnInit} from '@angular/core';
import {I18NService} from '@core';
import {ALAIN_I18N_TOKEN} from '@delon/theme';
import {NzModalService} from 'ng-zorro-antd/modal';
import {NzNotificationService} from 'ng-zorro-antd/notification';
import {NzTableQueryParams} from 'ng-zorro-antd/table';
import {finalize} from 'rxjs/operators';

import {Collector} from '../../../pojo/Collector';
import {CollectorService} from '../../../service/collector.service';

@Component({
  selector: 'app-setting-collectors',
  templateUrl: './collectors.component.html'
})
export class SettingCollectorsComponent implements OnInit {
  constructor(
    private notifySvc: NzNotificationService,
    private modal: NzModalService,
    private collectorService: CollectorService,
    @Inject(ALAIN_I18N_TOKEN) private i18nSvc: I18NService
  ) {}

  pageIndex: number = 1;
  pageSize: number = 8;
  total: number = 0;
  collectors!: Collector[];
  tableLoading: boolean = false;
  checkedCollectorIds = new Set<number>();
  // 搜索过滤相关属性
  search: string | undefined;

  ngOnInit(): void {
    this.loadCollectorsTable();
  }

  sync() {
    this.loadCollectorsTable();
  }

  loadCollectorsTable() {
    this.tableLoading = true;
    let collectorsInit$ = this.collectorService.loadCollectors(this.search, this.pageIndex - 1, this.pageSize).subscribe(
      message => {
        this.tableLoading = false;
        this.checkedAll = false;
        this.checkedCollectorIds.clear();
        if (message.code === 0) {
          let page = message.data;
          this.collectors = page.content;
          this.pageIndex = page.number + 1;
          this.total = page.totalElements;
        } else {
          console.warn(message.msg);
        }
        collectorsInit$.unsubscribe();
      },
      error => {
        this.tableLoading = false;
        collectorsInit$.unsubscribe();
        console.error(error.msg);
      }
    );
  }

  onDeleteCollectors() {
    if (this.checkedCollectorIds == null || this.checkedCollectorIds.size === 0) {
      this.notifySvc.warning(this.i18nSvc.fanyi('alert.center.notify.no-delete'), '');
      return;
    }
    this.modal.confirm({
      nzTitle: this.i18nSvc.fanyi('alert.center.confirm.delete-batch'),
      nzOkText: this.i18nSvc.fanyi('common.button.ok'),
      nzCancelText: this.i18nSvc.fanyi('common.button.cancel'),
      nzOkDanger: true,
      nzOkType: 'primary',
      nzClosable: false,
      nzOnOk: () => this.deleteCollectors(this.checkedCollectorIds)
    });
  }

  onDeleteOneCollector(collectorId: number) {
    let alerts = new Set<number>();
    alerts.add(collectorId);
    this.modal.confirm({
      nzTitle: this.i18nSvc.fanyi('common.confirm.delete'),
      nzOkText: this.i18nSvc.fanyi('common.button.ok'),
      nzCancelText: this.i18nSvc.fanyi('common.button.cancel'),
      nzOkDanger: true,
      nzOkType: 'primary',
      nzClosable: false,
      nzOnOk: () => this.deleteCollectors(alerts)
    });
  }

  deleteCollectors(collectorIds: Set<number>) {
    this.tableLoading = true;
    const deleteCollectors$ = this.collectorService.deleteCollectors(collectorIds).subscribe(
      message => {
        deleteCollectors$.unsubscribe();
        if (message.code === 0) {
          this.notifySvc.success(this.i18nSvc.fanyi('common.notify.delete-success'), '');
          this.loadCollectorsTable();
        } else {
          this.tableLoading = false;
          this.notifySvc.error(this.i18nSvc.fanyi('common.notify.delete-fail'), message.msg);
        }
      },
      error => {
        this.tableLoading = false;
        deleteCollectors$.unsubscribe();
        this.notifySvc.error(this.i18nSvc.fanyi('common.notify.delete-fail'), error.msg);
      }
    );
  }

  // begin: 列表多选分页逻辑
  checkedAll: boolean = false;
  onAllChecked(checked: boolean) {
    if (checked) {
      this.collectors.forEach(monitor => this.checkedCollectorIds.add(monitor.id));
    } else {
      this.checkedCollectorIds.clear();
    }
  }
  onItemChecked(monitorId: number, checked: boolean) {
    if (checked) {
      this.checkedCollectorIds.add(monitorId);
    } else {
      this.checkedCollectorIds.delete(monitorId);
    }
  }
  onTablePageChange(params: NzTableQueryParams) {
    const { pageSize, pageIndex, sort, filter } = params;
    this.pageIndex = pageIndex;
    this.pageSize = pageSize;
    this.loadCollectorsTable();
  }
  // end: 列表多选分页逻辑

  // start 新增修改Collector model
  isManageModalVisible = false;
  isManageModalOkLoading = false;
  isManageModalAdd = true;
  collector!: Collector;
  onNewCollector() {
    this.collector = new Collector();
    this.isManageModalVisible = true;
    this.isManageModalAdd = true;
  }
  onEditOneCollector(collectorValue: Collector) {
    this.collector = collectorValue;
    this.isManageModalVisible = true;
    this.isManageModalAdd = false;
  }
  onManageModalCancel() {
    this.isManageModalVisible = false;
  }
  onManageModalOk() {
    this.isManageModalOkLoading = true;
    this.collector.name = this.collector.name.trim();
    if (this.isManageModalAdd) {
      const modalOk$ = this.collectorService
        .newCollector(this.collector)
        .pipe(
          finalize(() => {
            modalOk$.unsubscribe();
            this.isManageModalOkLoading = false;
          })
        )
        .subscribe(
          message => {
            if (message.code === 0) {
              this.isManageModalVisible = false;
              this.notifySvc.success(this.i18nSvc.fanyi('common.notify.new-success'), '');
              this.loadCollectorsTable();
            } else {
              this.notifySvc.error(this.i18nSvc.fanyi('common.notify.new-fail'), message.msg);
            }
          },
          error => {
            this.notifySvc.error(this.i18nSvc.fanyi('common.notify.new-fail'), error.msg);
          }
        );
    } else {
      const modalOk$ = this.collectorService
        .editCollector(this.collector)
        .pipe(
          finalize(() => {
            modalOk$.unsubscribe();
            this.isManageModalOkLoading = false;
          })
        )
        .subscribe(
          message => {
            if (message.code === 0) {
              this.isManageModalVisible = false;
              this.notifySvc.success(this.i18nSvc.fanyi('common.notify.edit-success'), '');
              this.loadCollectorsTable();
            } else {
              this.notifySvc.error(this.i18nSvc.fanyi('common.notify.edit-fail'), message.msg);
            }
          },
          error => {
            this.notifySvc.error(this.i18nSvc.fanyi('common.notify.edit-fail'), error.msg);
          }
        );
    }
  }
  // end 新增修改告警定义model
}
