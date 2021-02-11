import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddNewCustomerComponent } from './admin-add-new-customer.component';

describe('AdminAddNewCustomerComponent', () => {
  let component: AdminAddNewCustomerComponent;
  let fixture: ComponentFixture<AdminAddNewCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddNewCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddNewCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
