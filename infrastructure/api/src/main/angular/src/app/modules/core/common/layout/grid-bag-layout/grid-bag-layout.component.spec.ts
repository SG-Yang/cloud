import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GridBagLayoutComponent } from './grid-bag-layout.component';

describe('GridBagLayoutComponent', () => {
  let component: GridBagLayoutComponent;
  let fixture: ComponentFixture<GridBagLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GridBagLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GridBagLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
