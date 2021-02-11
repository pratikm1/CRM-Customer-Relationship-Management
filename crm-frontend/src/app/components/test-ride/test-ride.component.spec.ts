import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestRideComponent } from './test-ride.component';

describe('TestRideComponent', () => {
  let component: TestRideComponent;
  let fixture: ComponentFixture<TestRideComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestRideComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestRideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
