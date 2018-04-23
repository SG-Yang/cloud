import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorderLayoutComponent } from './border-layout.component';

describe('BorderLayoutComponent', () => {
  let component: BorderLayoutComponent;
  let fixture: ComponentFixture<BorderLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorderLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorderLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
