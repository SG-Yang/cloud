import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkPermissionGroupComponent } from './link-permission-group.component';

describe('LinkPermissionGroupComponent', () => {
  let component: LinkPermissionGroupComponent;
  let fixture: ComponentFixture<LinkPermissionGroupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkPermissionGroupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkPermissionGroupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
