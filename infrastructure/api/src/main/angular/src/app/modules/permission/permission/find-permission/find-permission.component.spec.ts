import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindPermissionComponent } from './find-permission.component';

describe('FindPermissionComponent', () => {
  let component: FindPermissionComponent;
  let fixture: ComponentFixture<FindPermissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindPermissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindPermissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
