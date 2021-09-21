import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RmOrderDetailsComponent } from './rm-order-details.component';

describe('RmOrderDetailsComponent', () => {
  let component: RmOrderDetailsComponent;
  let fixture: ComponentFixture<RmOrderDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RmOrderDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RmOrderDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
