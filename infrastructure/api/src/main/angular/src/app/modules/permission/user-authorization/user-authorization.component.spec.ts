import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAuthorizationComponent } from './user-authorization.component';

describe('UserAuthorizationComponent', () => {
  let component: UserAuthorizationComponent;
  let fixture: ComponentFixture<UserAuthorizationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserAuthorizationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserAuthorizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
