import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RmTrackOrderComponent } from './rm-track-order.component';

describe('RmTrackOrderComponent', () => {
  let component: RmTrackOrderComponent;
  let fixture: ComponentFixture<RmTrackOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RmTrackOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RmTrackOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
