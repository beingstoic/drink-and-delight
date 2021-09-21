import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RmOrderUpdateComponent } from './rm-order-update.component';

describe('RmOrderUpdateComponent', () => {
  let component: RmOrderUpdateComponent;
  let fixture: ComponentFixture<RmOrderUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RmOrderUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RmOrderUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
