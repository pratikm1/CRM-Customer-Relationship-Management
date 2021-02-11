import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminVehicleUpdateComponent } from './admin-vehicle-update.component';

describe('AdminVehicleUpdateComponent', () => {
  let component: AdminVehicleUpdateComponent;
  let fixture: ComponentFixture<AdminVehicleUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminVehicleUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminVehicleUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
