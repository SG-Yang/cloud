import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PermissionGroupLinkageComponent } from './permission-group-linkage.component';

describe('PermissionGroupLinkageComponent', () => {
  let component: PermissionGroupLinkageComponent;
  let fixture: ComponentFixture<PermissionGroupLinkageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PermissionGroupLinkageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermissionGroupLinkageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
