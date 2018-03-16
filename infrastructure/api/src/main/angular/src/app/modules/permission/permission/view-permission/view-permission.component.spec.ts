import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPermissionComponent } from './view-permission.component';

describe('ViewPermissionComponent', () => {
  let component: ViewPermissionComponent;
  let fixture: ComponentFixture<ViewPermissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPermissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPermissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
