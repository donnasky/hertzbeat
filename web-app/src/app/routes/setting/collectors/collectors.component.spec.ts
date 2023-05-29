import {ComponentFixture, TestBed, waitForAsync} from '@angular/core/testing';

import {SettingCollectorsComponent} from './collectors.component';

describe('SettingCollectorsComponent', () => {
  let component: SettingCollectorsComponent;
  let fixture: ComponentFixture<SettingCollectorsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [SettingCollectorsComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SettingCollectorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
