import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyPermissionComponent } from './modify-permission.component';

describe('ModifyPermissionComponent', () => {
  let component: ModifyPermissionComponent;
  let fixture: ComponentFixture<ModifyPermissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyPermissionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyPermissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
