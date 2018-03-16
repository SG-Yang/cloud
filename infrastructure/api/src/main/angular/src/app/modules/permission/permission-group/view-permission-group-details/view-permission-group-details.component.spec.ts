import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPermissionGroupDetailsComponent } from './view-permission-group-details.component';

describe('ViewPermissionGroupDetailsComponent', () => {
  let component: ViewPermissionGroupDetailsComponent;
  let fixture: ComponentFixture<ViewPermissionGroupDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPermissionGroupDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPermissionGroupDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
