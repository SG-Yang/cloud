import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpringLayoutComponent } from './spring-layout.component';

describe('SpringLayoutComponent', () => {
  let component: SpringLayoutComponent;
  let fixture: ComponentFixture<SpringLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpringLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpringLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
