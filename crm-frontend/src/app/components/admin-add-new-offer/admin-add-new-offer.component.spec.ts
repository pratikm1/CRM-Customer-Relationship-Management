import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddNewOfferComponent } from './admin-add-new-offer.component';

describe('AdminAddNewOfferComponent', () => {
  let component: AdminAddNewOfferComponent;
  let fixture: ComponentFixture<AdminAddNewOfferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddNewOfferComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminAddNewOfferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
