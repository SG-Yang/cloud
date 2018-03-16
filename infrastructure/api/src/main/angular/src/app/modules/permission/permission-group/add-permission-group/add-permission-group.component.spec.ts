import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPermissionGroupComponent } from './add-permission-group.component';

describe('AddPermissionGroupComponent', () => {
  let component: AddPermissionGroupComponent;
  let fixture: ComponentFixture<AddPermissionGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddPermissionGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPermissionGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
